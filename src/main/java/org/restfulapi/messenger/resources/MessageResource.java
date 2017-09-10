package org.restfulapi.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.restfulapi.messenger.services.Comment;
import org.restfulapi.messenger.services.DataNotFoundException;
import org.restfulapi.messenger.services.Link;
import org.restfulapi.messenger.services.Message;
import org.restfulapi.messenger.services.MessageService;

@Path("messages")
@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MessageResource 
{
	MessageService service=new MessageService();

	@GET
	@Path("/{messageID}")
	public Message getMessage(@PathParam("messageID")int id,@Context UriInfo uriinfo )
	{
		Message msg=service.getMessage(id);
		if(service.getMessage(id)==null)
		{
			throw new DataNotFoundException("message with id "+id+"not found");
		}
		String uri=uriinfo.getBaseUriBuilder().path(MessageResource.class).path(Integer.toString(msg.getId())).build().toString();
		msg.addLink(uri,"self");
		
		String commenturi=uriinfo.getBaseUriBuilder().path(CommentResourse.class).path(MessageResource.class).path(MessageResource.class,"getCommentResource")
						  .resolveTemplate("messageID", msg.getId()).build().toString();
		
		msg.addLink(commenturi, "comments");
		
	return msg;
	}

	

	@GET
	public List<Message> getMessages(@QueryParam("year")int year,
											@QueryParam("start") int start,
											@QueryParam("size") int size)
	{
		if(year>0)
		{
			return service.getbyyear(year);
		}
		if(start>0 & size>0)
		{
			return service.get(start, size);
		}
		return service.getMessages();
	}
	
	@POST
	public Response addMessage(Message msg) throws URISyntaxException
	{
		return Response.created(new URI("/messenger/webapi/messages"+msg.getId())).entity(service.addMessage(msg)).build();
		
	}
	
	
	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID") int id,Message msg)
	{
		msg.setId(id);
		return service.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageID}")
	public void deleteMessage(@PathParam("messageID") int id)
	{
		 service.deleteMessage(id);
	}

	
	@Path("/{messageID}/comments")
	public CommentResourse getCommentResource()
	{
	return new CommentResourse();	
	}
}

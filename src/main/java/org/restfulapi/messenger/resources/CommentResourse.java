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
import javax.ws.rs.core.UriInfo;

import org.restfulapi.messenger.services.Comment;
import org.restfulapi.messenger.services.CommentService;
import org.restfulapi.messenger.services.DataNotFoundException;
import org.restfulapi.messenger.services.Message;
import org.restfulapi.messenger.services.MessageService;

@Path("/")
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

public class CommentResourse {
	private CommentService service = new CommentService();

	@GET
	@Path("/{commentID}")
	public Comment getComment(@PathParam("commentID") int id, @PathParam("messageID") int msgid,
			@Context UriInfo uriinfo) {
		Comment com = service.getComment(msgid, id);
		if (service.getComments(id) == null) {
			throw new DataNotFoundException("Comment with id " + id + "not found");
		}
		return com;
	}

	@GET
	public ArrayList<Comment> getComments(@PathParam("commentID") int id, @PathParam("messageID") int msgid,
			@Context UriInfo uriinfo) {
		return service.getComments(msgid);

	}

	@POST
	public Comment addComment(@PathParam("messageID") int msgid, Comment com) {
			return service.addComment(msgid, com);
	}

	@PUT
	@Path("/{commentID}")
	public Comment updateComment(@PathParam("messageID") int msgid, @PathParam("commentID") int comid, Comment com) {
		com.setId(comid);
		return service.updateComment(msgid, com);
	}

	@DELETE
	@Path("/{commentID}")
	public void deleteMessage(@PathParam("messageID") int msgid, @PathParam("commentID") int comid) {
		service.deleteComment(msgid, comid);
	}

}

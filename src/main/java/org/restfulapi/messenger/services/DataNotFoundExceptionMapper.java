package org.restfulapi.messenger.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage er=new ErrorMessage(404,exception.getMessage(),"link");
		return Response.status(Status.NOT_FOUND)
				.entity(er)
				.build();
	}

	

}

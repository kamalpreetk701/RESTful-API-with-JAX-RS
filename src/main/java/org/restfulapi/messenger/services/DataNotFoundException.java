package org.restfulapi.messenger.services;

import javax.ws.rs.ext.Provider;


public class DataNotFoundException extends RuntimeException
{

/**
	 * 
	 */
	private static final long serialVersionUID = 164439442444682486L;

public DataNotFoundException(String msg)
{
	super(msg);
}


}

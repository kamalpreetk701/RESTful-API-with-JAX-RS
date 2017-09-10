package org.restfulapi.messenger.services;

import java.util.ArrayList;
import java.util.HashMap;

public class Database 
{

	private static  HashMap<Integer,Message> messages=new HashMap();
	
	public static HashMap<Integer,Message> getMessages()
	{
		return messages;
	}
}

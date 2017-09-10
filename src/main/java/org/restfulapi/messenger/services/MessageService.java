package org.restfulapi.messenger.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MessageService {
	private HashMap<Integer, Message> messages = Database.getMessages();
	
	public MessageService()
	{
		
	}
	public ArrayList<Message> getMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(int id) {
		return messages.get(id);
	}

	public ArrayList<Message> getbyyear(int year)
	{
		ArrayList<Message> result =new ArrayList();
		Calendar cal=Calendar.getInstance();
		for(Message msg:messages.values())
		{
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR)==year)
				result.add(msg);
		}
		return result;
	}
	public List<Message> get(int start,int size)
	{
		ArrayList<Message> result =new ArrayList<Message>(messages.values());
		return  result.subList(start, start+size);
		
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		messages.put(message.getId(), message);
		return message;
	}

	public void deleteMessage(int id) {
		 messages.remove(id);
	}

}

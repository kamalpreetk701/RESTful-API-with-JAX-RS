package org.restfulapi.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;

public class CommentService 
{
	HashMap<Integer, Message> messages=Database.getMessages();
	
	
	public ArrayList<Comment> getComments(int msgid) {
		 HashMap<Integer,Comment> comments =(messages.get(msgid).getComments());
		 return new ArrayList(comments.values());
	}

	public Comment getComment(int msgid,int id) {
		return messages.get(msgid).getComments().get(id);
	}

	
	
	public Comment addComment(int msgid,Comment comment) {
		HashMap<Integer,Comment> comments =(messages.get(msgid).getComments());
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(int msgid,Comment comment) {
		HashMap<Integer,Comment> comments =(messages.get(msgid).getComments());
		comments.put(comment.getId(), comment);
		return comment;
	}

	public void deleteComment(int msgid,int id) {
		HashMap<Integer,Comment> comments =(messages.get(msgid).getComments());
		comments.remove(id);
	}

}

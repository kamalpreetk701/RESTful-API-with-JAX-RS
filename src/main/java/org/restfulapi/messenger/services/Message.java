package org.restfulapi.messenger.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private int id;
	private String msg;
	private Date created;
	private String author;
private ArrayList<Link> links=new ArrayList();
private HashMap<Integer,Comment> comments=new HashMap();

	
	public ArrayList<Link> getLinks() 
	{
	return links;
	}
	
	@XmlTransient
	public HashMap<Integer,Comment> getComments() {
		return comments;
	}
	
	public void setComments(HashMap<Integer,Comment> comments) {
		this.comments = comments;
	}
	
	public void setLinks(ArrayList<Link> links) {
	this.links = links;
	}

	public Message()
	{
		
	}
	public Message(int id, String msg, String author) {

		this.id = id;
		this.msg = msg;
		this.author = author;
		this.created = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void addLink(String uri, String rel) {
		Link l=new Link(uri,rel);
		links.add(l);	
	}

}

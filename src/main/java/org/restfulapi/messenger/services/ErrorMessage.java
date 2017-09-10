package org.restfulapi.messenger.services;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private int errorcode;
	private String error;
	private String documentation;
	public ErrorMessage()
	{
		
	}
	public ErrorMessage(int errorcode, String error, String documentation) {
		super();
		this.errorcode = errorcode;
		this.error = error;
		this.documentation = documentation;
	}
	public int getErrorcode() 
	{
		return errorcode;
	}
	public void setErrorcode(int errorcode) 
	{
		this.errorcode = errorcode;
	}
	public String getError() 
	{
		return error;
	}
	public void setError(String error) 
	{
		this.error = error;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}

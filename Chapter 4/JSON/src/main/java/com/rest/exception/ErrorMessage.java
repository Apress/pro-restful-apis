package com.rest.exception;

import javax.xml.bind.annotation.XmlRootElement;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
@SuppressWarnings("restriction")
@XmlRootElement(name="message")
public class ErrorMessage { 
@XmlElement public String code;
@XmlElement public String description;
@XmlElement public String link;
@XmlElement public Response.Status status;
   public ErrorMessage(String code,String description, String link, Response.Status status) {
        this.code = code;
        this.description = description;
        this.link = link;
        this.status = status;
   }
}             


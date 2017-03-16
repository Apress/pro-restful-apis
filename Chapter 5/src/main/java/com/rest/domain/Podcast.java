package com.rest.domain;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
@SuppressWarnings("restriction")
@XmlRootElement(name="podcast")
public class Podcast {
	@XmlElement public int id;
	@XmlElement public String link;
	@XmlElement public String feed;
	@XmlElement public String title;
	@XmlElement public String description;
	@XmlElement public String insertionDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getFeed() {
		return feed;
	}
	public void setFeed(String feed) {
		this.feed = feed;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInsertionDate() {
		return insertionDate;
	}
	public void setInsertionDate(String insertionDate) {
		this.insertionDate = insertionDate;
	}
}


package com.app.model;

public class Author {
	private String authorName;
	private String authorEmail;
	public Author() {
		super();
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", authorEmail=" + authorEmail + "]";
	}
	
}

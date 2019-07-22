package com.app.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.app.model.Author;
import com.app.model.Book;


public class BookHandler extends DefaultHandler {
	
	private boolean bookTitle=false;
	private boolean bookPrice=false;
	private boolean bookIsbh=false;
	private boolean authorName=false;
	private boolean authorEmail=false;
	
	private Book bk=null;
	private Author ath=null;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("----------Start Document-----------");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//System.out.println("----------Start Element-----------");
		if(qName.equals("ebs:book-info")) {
			 bk=new Book();
		}
		else if(qName.equals("sun:author-info")) {
			 ath=new Author();
		}
		else if(qName.equals("ebs:book-title")) {
			bookTitle=true;
		}else if(qName.equals("ebs:book-price")) {
			bookPrice=true;
		}
		else if(qName.equals("ebs:book-isbh")) {
			bookIsbh=true;
		}
		else if(qName.equals("sun:author-name")) {
			authorName=true;
		}else if(qName.equals("sun:author-email")) {
			authorEmail=true;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(bookTitle) {
			//System.out.println("Book Title : "+new String(ch,start,length));
			bk.setBookTitle(new String(ch,start,length));
			bookTitle=false;
		}
		else if(bookPrice) {
			bookPrice=false;
			//System.out.println("Book Price : "+new String(ch,start,length));
			bk.setBookPrice(Double.parseDouble(new String(ch,start,length)));
		}else if(bookIsbh) {
			bookIsbh=false;
			//System.out.println("Book ISBN : "+new String(ch,start,length));
			bk.setBookIsbn(new String(ch,start,length));
		}else if(authorName) {
			authorName=false;
			//System.out.println("Author Name : "+new String(ch,start,length));
			ath.setAuthorName(new String(ch,start,length));
		} else if(authorEmail) {
			authorEmail=false;
			//System.out.println("Author Email : "+new String(ch,start,length));
			ath.setAuthorEmail(new String(ch,start,length));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("----------End Element-----------");
		if(qName.equals("sun:author-info")) {
			bk.setAuthorDetails(ath);
		}
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println(bk);
		System.out.println("----------End Document-----------");
	}
}

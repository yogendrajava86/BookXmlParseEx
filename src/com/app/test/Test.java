package com.app.test;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.app.handler.BookHandler;


public class Test {
	public static void main(String[] args) throws Exception {
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		parser.parse(new File("Book.xml"), new BookHandler());
	}
}

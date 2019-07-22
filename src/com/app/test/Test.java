package com.app.test;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.app.handler.BookHandler;


public class Test {
	public static void main(String[] args) throws Exception {
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		
		boolean validStatus=validateXmlFromXsd("Book.xsd","Book.xml");
		if(validStatus) {
			parser.parse(new File("Book.xml"), new BookHandler());
		}else {
			System.out.println("Sorry, provided XML not valid.");
		}
		
		
	}
	public static boolean validateXmlFromXsd(String xsdPath,String xmlPath) {
		try {
		SchemaFactory sf=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema=sf.newSchema(new File(xsdPath));
		Validator validator=schema.newValidator();
		validator.validate(new StreamSource(xmlPath));
		}catch(Exception ex) {
			//ex.printStackTrace();
			return false;
		}
		return true;
	}
}

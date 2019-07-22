package com.app.model;

public class Book {
	private String bookTitle;
	private Double bookPrice;
	private String bookIsbn;
	private Author authorDetails;
	public Book() {
		super();
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public Author getAuthorDetails() {
		return authorDetails;
	}
	public void setAuthorDetails(Author authorDetails) {
		this.authorDetails = authorDetails;
	}
	@Override
	public String toString() {
		return "Book [bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + ", bookIsbn=" + bookIsbn
				+ ", authorDetails=" + authorDetails + "]";
	}
	
}

package business;

import java.io.Serializable;

import interfaces.PrimaryKey;

public class Book implements Serializable, PrimaryKey {
	
	private static final long serialVersionUID = 5720335497921250897L;

	private String ISBN;
	private String title;
	private boolean available;
	private Author author;
	private BookType type;

	public Book(String ISBN, String title, Author author, BookType type) {
		this.ISBN = ISBN;
		this.title = title;
		this.available = true;
		this.author = author;
		this.type = type;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public boolean isAvailable() {
		return available;
	}

	public Author getAuthor() {
		return author;
	}

	@Override
	public String getPrimaryKey() {
		return ISBN;
	}
}

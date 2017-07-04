package business;

import java.io.Serializable;

import com.project.interfaces.PrimaryKey;

public class BookCopy implements Serializable, PrimaryKey {

	private static final long serialVersionUID = 5654380069068491357L;
	
	private String ISBN;
	private int noOfCopy;
	private Book book;
	
	public BookCopy(String isbn, int noOfCopy, Book book){
		this.ISBN = isbn;
		this.noOfCopy = noOfCopy;
		this.book = book;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getNoOfCopy() {
		return noOfCopy;
	}

	public Book getBook() {
		return book;
	}

	@Override
	public String getPrimaryKey() {
		return ISBN;
	}
}

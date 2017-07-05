package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import interfaces.PrimaryKey;

public class Book implements Serializable, PrimaryKey {
	
	private static final long serialVersionUID = 5720335497921250897L;

	private String ISBN;
	private String title;
	private boolean available;
	private List<Author> authorlist;
	private String type;
	private List<BookCopy> listbookcopy;
	
	public Book(String ISBN, String title, Author a, BookCopy b, String type) {
		authorlist = new ArrayList<Author>();
		listbookcopy = new ArrayList<BookCopy>();
		this.ISBN = ISBN;
		this.title = title;
		this.available = true;
		authorlist = new ArrayList<>();
		this.type = type;
		addAuthor(a);
		addBookCopy(b);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Author> getAuthorlist() {
		return authorlist;
	}

	public String getType() {
		return type;
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

	public List<Author> getAuthor() {
		return authorlist;
	}

	@Override
	public String getPrimaryKey() {
		return ISBN;
	}
	
	public void addAuthor(Author a){
		authorlist.add(a);
	}
	
	public void addBookCopy(BookCopy b){
		listbookcopy.add(b);
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", available=" + available + ", authorlist=" + authorlist
				+ ", type=" + type + ", listbookcopy=" + listbookcopy + "]";
	}
}

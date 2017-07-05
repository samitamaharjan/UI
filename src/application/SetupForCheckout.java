package application;

import java.io.IOException;

import business.Address;
import business.Author;
import business.Book;
import business.BookCopy;
import business.BookType;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;

public class SetupForCheckout {

	public static void main(String[] args) throws IOException {
		FileManager<Book> bookManager = new FileManagerImpl<>("book");
		 
		bookManager.clean();
		Address addr1 = new Address("1000 N 4th St", "Fairfield", "52555", "IA");
		Author author = new Author("Appollo", "Jason", "2589654", addr1, "cred", "bio");
		BookCopy bookCopy = new BookCopy("1000");
		Book java = new Book("1111", "Java", author, bookCopy, BookType.REFERENCE.toString());
		java.addBookCopy(new BookCopy("1000"));
		java.addBookCopy(new BookCopy("1001"));
		
		BookCopy bookCopy1 = new BookCopy("1000");
		Book python = new Book("2222", "Python", author, bookCopy1, BookType.REGULAR.toString());
		python.addBookCopy(new BookCopy("2000"));
		python.addBookCopy(new BookCopy("2001"));
		
		bookManager.insert(java);
		bookManager.insert(python);
		bookManager.print();
		
		FileManager<LibraryMember> memberManager = new FileManagerImpl<>("libraryMember");
		memberManager.clean();
		
		LibraryMember john = new LibraryMember("1051", "John", "Smith", "2589642", null);
		LibraryMember samita = new LibraryMember("1052", "Samita", "Maharjan", "2058651", null);
		
		memberManager.insert(john);
		memberManager.insert(samita);
		memberManager.print();
		bookManager.print();
		
	}
}

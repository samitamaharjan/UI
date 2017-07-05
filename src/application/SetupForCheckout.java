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
		
		Address add1 = new Address();
		Author author = new Author("Appollo", "Jason", "2589654", add1, "cred", "bio");
		BookCopy bookCopy = new BookCopy("1000", 6);
		Book java = new Book("1111", "Java", author, bookCopy, BookType.REFERENCE.toString());
		
		bookManager.insert(java);
		bookManager.print();
		
		FileManager<LibraryMember> memberManager = new FileManagerImpl<>("libraryMember");
		memberManager.clean();
		
		LibraryMember john = new LibraryMember("1051", "John", "Smith", "2589642", null);
		LibraryMember samita = new LibraryMember("1052", "Samita", "Maharjan", "2058651", null);
		
		memberManager.insert(john);
		memberManager.insert(samita);
		memberManager.print();
		
	}
}

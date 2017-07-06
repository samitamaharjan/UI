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
		Author author1 = new Author("Appollo", "Jason", "2589654", addr1, "cred", "bio");
		BookCopy bookCopy1 = new BookCopy("1000");
		Book java = new Book("1111", "Java", author1, bookCopy1, BookType.REFERENCE.toString());
		java.addBookCopy(new BookCopy("1001"));
		java.addBookCopy(new BookCopy("1002"));
		
		BookCopy bookCopy2 = new BookCopy("2000");
		Book python = new Book("2222", "Python", author1, bookCopy2, BookType.REGULAR.toString());
		python.addBookCopy(new BookCopy("2001"));
		python.addBookCopy(new BookCopy("2002"));
		
		BookCopy bookCopy3 = new BookCopy("3000");
		Address addr2 = new Address("1250 N 4th St", "Fairfield", "52555", "IA");
		Author author2 = new Author("Alex", "Johnson", "2589654", addr2, "cred", "bio");
		Book hadoop = new Book("3333", "Hadoop", author2, bookCopy3, BookType.REGULAR.toString());
		
		BookCopy bookCopy4 = new BookCopy("4000");
		Author author3 = new Author("Tony", "Bond", "2589654", addr2, "cred", "bio");
		Book Ruby = new Book("4444", "Ruby", author3, bookCopy4, BookType.REFERENCE.toString());
		
		bookManager.insert(java);
		bookManager.insert(python);
		bookManager.insert(hadoop);
		bookManager.insert(Ruby);
		bookManager.print();
		
		/*FileManager<LibraryMember> memberManager = new FileManagerImpl<>("libraryMember");
		memberManager.clean();
		
		LibraryMember john = new LibraryMember("1051", "John", "Smith", "2589642", null);
		LibraryMember samita = new LibraryMember("1052", "Samita", "Maharjan", "2058651", null);
		
		memberManager.insert(john);
		memberManager.insert(samita);
		memberManager.print();
		bookManager.print();*/
		
	}
}

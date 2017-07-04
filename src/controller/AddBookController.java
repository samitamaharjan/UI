package controller;

import com.project.manager.FileManager;
import com.project.manager.FileManagerImpl;
import com.project.model.Address;
import com.project.model.Author;
import com.project.model.Book;
import com.project.model.BookType;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AddBookController extends AbstractController{
	@FXML
	TextField title;
	
	@FXML
	TextField isbn;
	
	@FXML
	TextField booktype;
	
	private Button btnAddBook;
	
	public void addBookClicked(){
		if (title.getText().isEmpty() || isbn.getText().isEmpty() || booktype.getText().isEmpty()) 
		{
			showAlert(AlertType.ERROR, "Please enter the details");
		}
		else{
			String bookTitle = title.getText().toString();
			String bookIsbn = isbn.getText().toString();
			// BookType bookType1 = booktype.getText().toString();
			Address addr = new Address("1425 N 3rd St", "Fairfiel", "98004", "IA");
			Author author = new Author("Alex", "Smith", "25015655", addr, true, "shfg");

			try {
				FileManager<Book> bookManager = new FileManagerImpl<>("book");
				bookManager.insert(new Book(bookTitle, bookIsbn, author, bookType1));
				/*Book book = new Book(bookTitle, bookIsbn, bookType);
				book.addMember(book);*/
				// call add book method from dao
				
				//clearField(bookTitle,bookIsbn,bookType1);
				showAlert(AlertType.CONFIRMATION,"Book added successfully");
			} 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Book not added");
			}
			
		}

}
}

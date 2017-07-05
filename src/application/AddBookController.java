package application;



import business.Address;
import business.Author;
import business.Book;
import business.BookCopy;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AddBookController extends AbstractController{
	ObservableList<String> booktypeList = FXCollections.observableArrayList("Regular","Special");
	
	@FXML
	TextField title;
	@FXML
	TextField isbn;
	
	@FXML
	TextField bookcopyid;
	
	@FXML
	TextField numberofcopies;
	
	@FXML
	TextField authorFName;
	@FXML
	TextField authorLName;
	@FXML
	TextField authorStreet;
	@FXML
	TextField authorCity;
	@FXML
	TextField authorState;
	@FXML
	TextField authorZip;
	@FXML
	TextField authorPhone;
	@FXML
	TextField authorCredentials;
	@FXML
	TextArea authorBiopic;
	
	@FXML
	private Button btnAddBook;
	
	@FXML
	private ChoiceBox booktypeBox;
	
	
	@FXML
	private void initialize(){
		booktypeBox.setValue("Regular");
		booktypeBox.setItems(booktypeList);
		
		
	}
	
	public void addBookClicked(){
		if (title.getText().isEmpty() || isbn.getText().isEmpty() || authorFName.getText().isEmpty()) 
		{
			showAlert(AlertType.ERROR, "Please enter all details marked with asterisk");
		}
		else{
			String bookTitle = title.getText().toString();
			String bookIsbn = isbn.getText().toString();
			String bookcoid = bookcopyid.getText();
			String numofcopy = numberofcopies.getText();
			String authorFirstName = authorFName.getText().toString();
			String authorLastName = authorLName.getText().toString();
			String authorSt = authorStreet.getText().toString();
			String authorC = authorCity.getText().toString();
			String authorStr = authorState.getText().toString();
			String authorZipp = authorZip.getText().toString();
			String authorPh = authorPhone.getText().toString();
			String authorCre = authorCredentials.getText().toString();
			String authorBio = authorBiopic.getText().toString();
			String booktype = booktypeBox.getValue().toString();


			try {
				Address addr = new Address(authorSt, authorC, authorZipp, authorStr);
				Author author = new Author(authorFirstName, authorLastName, authorPh, addr, authorCre, authorBio);
				BookCopy bookcopy = new BookCopy(bookcoid);
				Book book = new Book(bookIsbn, bookTitle, author, bookcopy, booktype);
				
				FileManager<Book> filemanager = new FileManagerImpl<Book>("book");
				filemanager.insert(book);
				
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

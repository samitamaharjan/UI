package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import business.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SuccessfullyIssued extends AbstractController {
	ObservableList<String> booktypeList = FXCollections.observableArrayList("Regular","Special");
	
	@FXML
	TextField memId;
	@FXML
	TextField bookTitle;
	@FXML
	TextField bookIsbn;
	@FXML
	TextField dateOfIssue;
	@FXML
	TextField overdueDate;
	@FXML
	private Button btnOkConfirmation;
	@FXML
	AnchorPane closeCurrentWindow;
	
	private Book book;
	
	public void setBookInformation(Book book) {
		bookTitle.setText(book.getTitle());
		bookIsbn.setText(book.getISBN());
	}
	
	public void addBookClicked(){
			
			try {
				Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
				
				current.hide();
			} 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Some error occoured");
			}
			
		}


}

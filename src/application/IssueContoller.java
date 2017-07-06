package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import business.Book;
import business.CheckoutRecord;
import dao.FileManager;
import dao.FileManagerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class IssueContoller extends AbstractController implements Initializable {

	@FXML
	private TableView<Book> bookTable;
	@FXML
	private TableColumn<Book, String> ISBN;
	@FXML
	private TableColumn<Book, String> bookTitle;
	@FXML
	private TableColumn<Book, String> type;
	@FXML
	private TableColumn<Book, String> noOfCopy;
	@FXML
	private Button btnIssueBook;
	@FXML
	private ObservableList<Book> bookList;
	
	private String isbnNo;
	
//	public IssueContoller() {
//		
//	}
//	
//	public IssueContoller(String isbnNo) {
//		this.isbnNo = isbnNo;
//	}
	
	private FileManager<Book> bookManager = new FileManagerImpl<>("book");
	FileManager<CheckoutRecord> checkoutRecordManager = new FileManagerImpl<>("checkoutRecord");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
		bookTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		type.setCellValueFactory(new PropertyValueFactory<Book, String>("type"));
		noOfCopy.setCellValueFactory(new PropertyValueFactory<Book, String>("count"));
	}
	
	public void setBookToUI(String isbnNo) {
		List<Book> books = new ArrayList<>();
		books.add(bookManager.findByPrimaryKey(isbnNo));
		bookList = FXCollections.observableArrayList(books);		
		bookTable.getItems().setAll(bookList);
	}

	public void issueClicked() {
		
		try {
			/*Book book = bookManager.findByPrimaryKey(ISBN.getText());
			BookCopy bc = book.getAvailableBookCopy();
			bc.setAvailable(false);

			CheckoutRecordEntry entry = new CheckoutRecordEntry(bc);
			CheckoutRecord checkoutRecord = checkoutRecordManager.findByPrimaryKey(ISBN.getText());
			checkoutRecord.addEntry(entry);
			 */
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/SuccessfullyIssued.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
            stage.setTitle("Confirmation");
			stage.setScene(new Scene(root, 700, 500));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			showAlert(AlertType.ERROR, "Book cannot issue.");
		}

	}
}

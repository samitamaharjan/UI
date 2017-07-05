package application;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import business.Address;
import business.Author;
import business.Book;
import business.BookCopy;
import business.BookType;
import business.CheckoutRecord;
import business.CheckoutRecordEntry;
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
	private FileManager<Book> bookManager = new FileManagerImpl<>("book");
	FileManager<CheckoutRecord> checkoutRecordManager = new FileManagerImpl<>("checkoutRecord");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
		bookTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		type.setCellValueFactory(new PropertyValueFactory<Book, String>("type"));
		noOfCopy.setCellValueFactory(new PropertyValueFactory<Book, String>("count"));

		List<Book> books = bookManager.findAll();
		bookList = FXCollections.observableArrayList(books);
		
		List<Book> showBooks = new ArrayList<Book>();
		
		for (Book b : books) {
			if (ISBN.getText().equals(b.getISBN().toString())) {
				showBooks.add(b);
			}
		}
		
		bookTable.getItems().setAll(bookList);
		
	}

	public void issueClicked() {
		CheckoutBookAvailContoller check = new CheckoutBookAvailContoller();
		String memberID = check.getCheckoutMemIdText();

		try {
			Book book = bookManager.findByPrimaryKey(ISBN.getText());
			BookCopy bc = book.getAvailableBookCopy();
			bc.setAvailable(false);

			CheckoutRecordEntry entry = new CheckoutRecordEntry(bc);
			CheckoutRecord checkoutRecord = checkoutRecordManager.findByPrimaryKey(memberID);
			checkoutRecord.addEntry(entry);

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/SuccessfullMsg.fxml"));
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

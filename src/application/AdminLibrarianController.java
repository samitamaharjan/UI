package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AdminLibrarianController {
	@FXML
	private Button addLibMem;
	@FXML
	private Button editLibMem;
	@FXML
	private Button addBook;
	@FXML
	private Button checkoutBook;
	
	public void addLibMemClick(){
		 try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/AddMember.fxml"));
	            Parent root = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setTitle("Add Library Member");
	            stage.setScene(new Scene(root,700,500)); 
	            stage.show();
	          } catch(Exception e) {
	        	  e.printStackTrace();
	          }
	}
	public void editLibMemClick(){
		try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/application/SearchEditMember.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Edit Library Member");
            stage1.setScene(new Scene(root1)); 
            stage1.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
	public void addBookClick(){
		try{
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/application/AddBook.fxml"));
            Parent root2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Add Book");
            stage2.setScene(new Scene(root2,700,500)); 
            stage2.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
	public void checkoutBookClick(){
		try{
            FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("/application/CheckoutBook.fxml"));
            Parent root4 = (Parent) fxmlLoader4.load();
            Stage stage4 = new Stage();
            stage4.setTitle("Checkout Book");
            stage4.setScene(new Scene(root4)); 
            stage4.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
}

package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdministratorController {
	
	@FXML
	private Button btnAddMember;
	
	@FXML
	private Button btnEditMember;
	
	@FXML
	private Button btnAddBook;
	
	public void addMemberClicked(){
	
		 try{
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/AddMember.fxml"));
	            Parent root = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setTitle("Add Library Member");
	            stage.setScene(new Scene(root)); 
	            stage.show();
	          } catch(Exception e) {
	        	  e.printStackTrace();
	          }

	}
	
	public void editMemberClicked(){
		try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/application/EditMember.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Edit Library Member");
            stage1.setScene(new Scene(root1)); 
            stage1.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
	
	public void addBookClicked(){
		try{
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/application/AddBook.fxml"));
            Parent root2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Add Book");
            stage2.setScene(new Scene(root2)); 
            stage2.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}

	
}

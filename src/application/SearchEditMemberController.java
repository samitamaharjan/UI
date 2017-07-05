package application;

import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SearchEditMemberController extends AbstractController{

	@FXML
	TextField searchMember;
	
	private Button searchMemberBtn;
	private FileManager<LibraryMember> fileManager = new FileManagerImpl<>("libraryMember");
	
	public void searchMemberClicked(){
		if (searchMember.getText().isEmpty()) 
		{
			showAlert(AlertType.ERROR, "Please enter the member id");
		}
		else{
			
			try {
				String searchMemberId = searchMember.getText().toString();
				if (!fileManager.exists(searchMemberId)) {
					showAlert(AlertType.ERROR, "Invalid member id");
					return;
				}
				
				FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/application/EditMember.fxml"));
	            Parent root1 = (Parent) fxmlLoader1.load();
	            Stage stage1 = new Stage();
	            stage1.setTitle("Edit Library Member");
	            stage1.setScene(new Scene(root1,700,600)); 
	            stage1.show();
		    } 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Sorry, there is an error!");
			}
			
		}

}
}

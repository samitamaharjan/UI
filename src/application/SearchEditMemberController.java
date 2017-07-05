package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchEditMemberController extends AbstractController{

	@FXML
	TextField searchMember;
	
	private Button searchMemberBtn;
	
	public void searchMemberClicked(){
		if (searchMember.getText().isEmpty()) 
		{
			showAlert(AlertType.ERROR, "Please enter the member id");
		}
		else{
			String searcMemberId = searchMember.getText().toString();

			try {
				// call search method from dao
				
		            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/application/EditMember.fxml"));
		            Parent root1 = (Parent) fxmlLoader1.load();
		            Stage stage1 = new Stage();
		            stage1.setTitle("Edit Library Member");
		            stage1.setScene(new Scene(root1,700,500)); 
		            stage1.show();
		          } 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Member not found");
			}
			
		}

}
}

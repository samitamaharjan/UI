package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class LoginController extends AbstractController{
	
		
	@FXML
	private TextField txtusername;
	
	@FXML
	private TextField txtpassword;
	
	@FXML
	private Label lblmessage;
	
	@FXML
	private Button btnsubmit;
	
	public void clicked(){
		
		String name=txtusername.getText();
		String password=String.valueOf(txtpassword.getText());
		
		if(name.isEmpty() || password.isEmpty()){
			
			showAlert(AlertType.ERROR,"Please enter details");
			return;
		}
		
		if(name.equals("admin")&& password.equals("admin123")){
			System.out.println("succes");
			
		}else{
			showAlert(AlertType.ERROR, "Invalid Username / Password");
			System.out.println("error");
			txtusername.setText("");
			txtpassword.setText("");
		}
	}

}


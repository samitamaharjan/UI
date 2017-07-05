package application;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import business.LoginMember;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import managers.FileManager;
import managers.FileManagerImpl;


public class LoginController extends AbstractController{
	
	
	@FXML
	private TextField txtusername;
	
	@FXML
	private TextField txtpassword;
	
	@FXML
	private Label lblmessage;
	
	@FXML
	private Button btnsubmit;
	
	@SuppressWarnings("unchecked")
	public void clicked(){
		
		String name=txtusername.getText();
		String password=String.valueOf(txtpassword.getText());
		
		if(name.isEmpty() || password.isEmpty()){
			
			showAlert(AlertType.ERROR,"Please enter details");
			return;
		}
		
		List<LoginMember> list = new ArrayList<>();
		FileManager<LoginMember> loginMember = new FileManagerImpl<>("loginBoth");
		
		try (ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream("login"))) {
				list = (List<LoginMember>) ois.readObject();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		if (loginMember.findByPrimaryKey(name) == null) {
			showAlert(AlertType.ERROR, "Invalid Username / Password");
		} else {
			for (LoginMember mem : list) {
				if (name.equals(mem.getUserId())
						&& password.equals(mem.getPassword())) {
					System.out.println("success");
				}
			}
			System.out.println("Invalid username/password");			
		}
		
		/*if(name.equals("admin")&& password.equals("admin123")){
			System.out.println("succes");
			
		} else {
			showAlert(AlertType.ERROR, "Invalid Username / Password");
			System.out.println("error");
			txtusername.setText("");
			txtpassword.setText("");
		}*/
	}

}


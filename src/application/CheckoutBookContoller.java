package application;

import business.Address;
import business.LibraryMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class CheckoutBookContoller extends AbstractController{
	@FXML
	private TextField checkoutMemIdText;
	@FXML
	private TextField checkoutMemIsbnText;
	@FXML
	private Button btnSubmit;
	
public void checkAvailibilityClicked(ActionEvent event){
		
		if (checkoutMemIdText.getText().isEmpty() || checkoutMemIsbnText.getText().isEmpty()) 
		{
			showAlert(AlertType.WARNING, "Please enter the details");
		}
		else{
			String memberID = checkoutMemIdText.getText().toString();
			String isbnNo = checkoutMemIsbnText.getText().toString();

			try {
				//Address add = new Address(memberID, isbnNo);
				//mem.addMember(mem); 
				// call update checkout record method from dao
				
				
				clearField(checkoutMemIdText,checkoutMemIsbnText);
				
				showAlert(AlertType.CONFIRMATION,"Book checkout successfully");
			} 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Book cannot checkout");
			}
			
		}
}
}

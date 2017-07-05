package application;

import business.Address;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddMemberController extends AbstractController{
	
	@FXML
	TextField memId;
	
	@FXML
	TextField fname;
	
	@FXML
	TextField lname;
	
	@FXML
	TextField street;
	
	@FXML
	TextField city;
	
	@FXML
	TextField state;
	
	@FXML
	TextField zip;
	
	@FXML
	TextField phone;
	
	@FXML
	private Button btnAddMember;
	
	
	
	public void addMemberClicked(ActionEvent event){
		
		if (memId.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() || street.getText().isEmpty() || city.getText().isEmpty()|| state.getText().isEmpty() || zip.getText().isEmpty() || phone.getText().isEmpty()) 
		{
			showAlert(AlertType.WARNING, "Please enter the details");
		}
		else{
			String memberID = memId.getText().toString();
			String firstName = fname.getText().toString();
			String lastName = lname.getText().toString();
			String phoneno = phone.getText().toString();
			String streetname = street.getText().toString();
			String cityin = city.getText().toString();
			String stateOfCountry = state.getText().toString();
			String zipCode = zip.getText().toString();

			try {
				Address add = new Address(streetname, cityin, stateOfCountry, zipCode);
				LibraryMember mem = new LibraryMember(memberID, firstName, lastName, phoneno, add);
				FileManager<LibraryMember> filemanager = new FileManagerImpl<LibraryMember>("member");
				filemanager.insert(mem);
				// call add member method from dao
				
				filemanager.findAll();
				
				
				clearField(memId,fname,lname,phone,street,city,state,zip);
				
				showAlert(AlertType.CONFIRMATION,"Member added successfully");
			} 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Member not added");
			}
			
		}
	}

}

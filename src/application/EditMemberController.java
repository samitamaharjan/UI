package application;

import business.Address;
import business.LibraryMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import managers.FileManager;
import managers.FileManagerImpl;

public class EditMemberController extends AbstractController{
	
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
	private Button btnEditMember;
	
	public void editMemberClicked(ActionEvent event){
		if (memId.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() || street.getText().isEmpty() || city.getText().isEmpty()|| state.getText().isEmpty() || zip.getText().isEmpty() || phone.getText().isEmpty()) 
		{
			showAlert(AlertType.WARNING, "Please enter all the details");
		}
		else{
			String memberID = memId.getText().toString();
			String firstName = fname.getText().toString();
			String lastName = lname.getText();
			String phoneno = phone.getText();
			String streetname = street.getText();
			String cityin = city.getText();
			String stateOfCountry = state.getText();
			String zipCode = zip.getText();

			try {
				FileManager<LibraryMember> memManager = new FileManagerImpl<>("libraryMember");
			
				Address addr = new Address(streetname, cityin, stateOfCountry, zipCode);
				LibraryMember mem = new LibraryMember(memberID, firstName, lastName, phoneno, addr);
				
				memManager.edit(mem);
				memManager.findAll();
				
				clearField(memId,fname,lname,phone,street,city,state,zip);
				
				showAlert(AlertType.CONFIRMATION,"Member details changed");
			} 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Member details not changed");
			}
			
		}
	}

}
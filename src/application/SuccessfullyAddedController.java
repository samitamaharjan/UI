package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SuccessfullyAddedController {
	@FXML
	private Button popupDisplay;
	
	public void showPopupClick(){
		Stage newStage = new Stage();
		VBox comp = new VBox();
		
		Label message = new Label("Book has been issued successfully");
		message.setId("custom-label");
		message.setStyle("-fx-font: normal bold 20px 'serif' ");
		message.setStyle("-fx-padding: 20px");
		//message.setStyle("-fx-text-alignment: center");
		
		comp.getChildren().add(message);

		Scene stageScene = new Scene(comp, 500, 200);
		newStage.setScene(stageScene);
		newStage.show();
	}

}

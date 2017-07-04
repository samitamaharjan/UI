package controller;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Library Management");
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/controller/AddMember.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/application/CheckoutBook.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/application/Admin_Librarian.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("/application/SuccessfullMsg.fxml"));
			
			
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

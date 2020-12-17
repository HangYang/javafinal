package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Register {
	public Register() {
		//Load out Register.fxml
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
			Scene scene = new Scene(root,400,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Register");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerFrame {
	public ManagerFrame() {
		//Load out Register.fxml
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ManagerFrame.fxml"));
			Scene scene = new Scene(root,1024,720);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Manager");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

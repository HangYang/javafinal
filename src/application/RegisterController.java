package application;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
	@FXML
	private TextField txtusername;
	@FXML
	private TextField txtpassword;
	@FXML
	private Button btregister;
	@FXML
	private Button btcancel;
	
	public void Register() {
		String Name = txtusername.getText().trim();
		String Password = txtpassword.getText().trim();
		
		String sql = "insert into Guest(UserName,PassWord) values(?,?)";
		String[] paras = new String[2];
		paras[0] = Name;
		paras[1] = Password;
		
		//
		Connect cnt = new Connect();
		boolean r = cnt.updExecute(sql, paras);
		if (r) {
			JOptionPane.showMessageDialog(null, "Succeed Register");
			Stage stage = (Stage)btcancel.getScene().getWindow();
			stage.close();
		}
	}
	
	public void cancel() {
		Stage stage = (Stage)btcancel.getScene().getWindow();
		stage.close();
	}
}

package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;

import javafx.scene.control.PasswordField;

public class LoginController {
	public static String userName = null;
	public static String password = null;
	@FXML
	private TextField txtUserName;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private RadioButton btManager;
	@FXML
	private RadioButton btGuest;
	@FXML
	private Button btRegister;
	@FXML
	private Button btLogin;
	
	//Handle Business Logic
	//Get id & password 
	public void CheckLogin() {
		String inputName = txtUserName.getText().trim();
		String inputPwd = txtPassword.getText().trim();
		Connect cnt = new Connect();
		String[] paras = new String[2];
		paras[0] = inputName;
		paras[1] = inputPwd;
		userName = inputName;
		password = inputPwd;
		
		if (btManager.isSelected()) {
			String sql = "select count(*) from Users where UserName = ? and PassWord = ? ";
			ResultSet rs = cnt.queryExecute(sql,paras);
			try {
				rs.next();
				int count = rs.getInt(1);
				if (count == 1) {
					//Login MainFrame
					new ManagerFrame();
					Stage stage = (Stage)btRegister.getScene().getWindow();
					stage.close();
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong UserName or PassWord");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if (btGuest.isSelected()) {
			String sql1 = "select count(*) from Guest where UserName = ? and PassWord = ? ";
			ResultSet rs1 = cnt.queryExecute(sql1,paras);
			try {
				rs1.next();
				int count1 = rs1.getInt(1);
				if (count1 == 1) {
					//Login MainFrame
					new GuestFrame();
					Stage stage = (Stage)btRegister.getScene().getWindow();
					stage.close();
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong UserName or PassWord");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void register() {
		new Register();
	}
}

package application;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.MenuItem;

import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class ManagerFrameController {
	@FXML
	private AnchorPane PaneNewPlayer;
	@FXML
	private TextField txtid;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtHeight;
	@FXML
	private TextField txtWeight;
	@FXML
	private TextField txtAVP;
	@FXML
	private TextField txtAVR;
	@FXML
	private TextField txtAVA;
	@FXML
	private TextField txtTOP;
	@FXML
	private TextField txtTOR;
	@FXML
	private TextField txtTOA;
	@FXML
	private Button btAdd;
	@FXML
	private Button btClear;
	@FXML
	private Button btCancel;
	@FXML
	private AnchorPane PaneEditPlayer;
	@FXML
	private TextField txtSearch;
	@FXML
	private MenuItem SearchID;
	@FXML
	private MenuItem SearchFN;
	@FXML
	private MenuItem SearchLN;
	@FXML
	private MenuItem SearchHeight;
	@FXML
	private MenuItem SearchWeight;
	@FXML
	private MenuItem SearchAVP;
	@FXML
	private MenuItem SearchAVR;
	@FXML
	private MenuItem SearchAVA;
	@FXML
	private MenuItem SearchTOP;
	@FXML
	private MenuItem SearchTOR;
	@FXML
	private MenuItem SearchTOA;
	@FXML
	private MenuItem EditID;
	@FXML
	private MenuItem EditFirstName;
	@FXML
	private MenuItem EditLastName;
	@FXML
	private MenuItem EditHeight;
	@FXML
	private MenuItem EditWeight;
	@FXML
	private MenuItem EditAVP;
	@FXML
	private MenuItem EditAVR;
	@FXML
	private MenuItem EditAVA;
	@FXML
	private MenuItem EditTOP;
	@FXML
	private MenuItem EditTOR;
	@FXML
	private MenuItem EditTOA;
	@FXML
	private MenuItem OrderID;
	@FXML
	private MenuItem OrderFirstName;
	@FXML
	private MenuItem OrderLastName;
	@FXML
	private MenuItem OrderHeight;
	@FXML
	private MenuItem OrderWeight;
	@FXML
	private MenuItem OrderAVP;
	@FXML
	private MenuItem OrderAVR;
	@FXML
	private MenuItem OrderAVA;
	@FXML
	private MenuItem OrderTOP;
	@FXML
	private MenuItem OrderTOR;
	@FXML
	private MenuItem OrderTOA;
	@FXML
	private TableView<Player> TableEdit;
	@FXML
	private TableColumn<Player, String> Tableid;
	@FXML
	private TableColumn<Player, String> TableFirstName;
	@FXML
	private TableColumn<Player, String> TableLastName;
	@FXML
	private TableColumn<Player, Double> TableHeight;
	@FXML
	private TableColumn<Player, Double> TableWeight;
	@FXML
	private TableColumn<Player, Double> TableAVP;
	@FXML
	private TableColumn<Player, Double> TableAVR;
	@FXML
	private TableColumn<Player, Double> TableAVA;
	@FXML
	private TableColumn<Player, Integer> TableTOP;
	@FXML
	private TableColumn<Player, Integer> TableTOR;
	@FXML
	private TableColumn<Player, Integer> TableTOA;
	
	//create & initialize data
	private final ObservableList<Player> cellData = FXCollections.observableArrayList();
	
	public void NewPlayer() {
		PaneNewPlayer.setVisible(true);
		PaneEditPlayer.setVisible(false);
	}
	
	public void EditPlayer() {
		PaneNewPlayer.setVisible(false);
		PaneEditPlayer.setVisible(true);
	}
	
	//when click ADD then insert to Database
	public void AddPlayer() {
		//Get information
		String id = txtid.getText().trim();
		String firstName = txtFirstName.getText().trim();
		String lastName = txtLastName.getText().trim();
		double height = Double.parseDouble(txtHeight.getText().trim());
		double weight = Double.parseDouble(txtWeight.getText().trim());
		double avp = Double.parseDouble(txtAVP.getText().trim());
		double avr = Double.parseDouble(txtAVR.getText().trim());
		double ava = Double.parseDouble(txtAVA.getText().trim());
		int top = Integer.parseInt(txtTOP.getText().trim());
		int tor = Integer.parseInt(txtTOR.getText().trim());
		int toa = Integer.parseInt(txtTOA.getText().trim());
		
		//diao yong MainÖÐ updExecute, sql
		Connect cnt = new Connect();
		String sql = "insert into NBA values(?,?,?,?,?,?,?,?,?,?,?)";
		String[] paras = new String[11];
		paras[0] = id;
		paras[1] = firstName;
	    paras[2] = lastName;
	    paras[3] = "" + height;
	    paras[4] = "" + weight;
	    paras[5] = "" + avp;
	    paras[6] = "" + avr;
	    paras[7] = "" + ava;
	    paras[8] = "" + top;
	    paras[9] = "" + tor;
	    paras[10] = "" + toa;
	    if (cnt.updExecute(sql, paras)) {
	    	JOptionPane.showMessageDialog(null, "Succeed Add");
	    }
	    else {
	    	JOptionPane.showMessageDialog(null, "Fail to Add");
	    }
	}
	
	public void clear() {
		txtid.clear();
		txtFirstName.clear();
		txtLastName.clear();
		txtHeight.clear();
		txtWeight.clear();
		txtAVP.clear();
		txtAVR.clear();
		txtAVA.clear();
		txtTOP.clear();
		txtTOR.clear();
		txtTOA.clear();
	}
	
	public void cancel() {
		PaneNewPlayer.setVisible(false);
	}
	
	//show
	@FXML
	private void initialize() {
		Connect cnt = new Connect();
		String sql = "select * from NBA";
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerid() {
		//get id
		String inputid = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where ID like ?";
		String[] paras = new String[1];
		paras[0] = inputid;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerFirstName() {
		//get id
		String inputFN = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME like ?";
		String[] paras = new String[1];
		paras[0] = inputFN;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerLastName() {
		//get id
		String inputLN = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where LASTNAME like ?";
		String[] paras = new String[1];
		paras[0] = inputLN;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerHeight() {
		//get id
		String inputHeight = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where HEIGHT like ?";
		String[] paras = new String[1];
		paras[0] = inputHeight;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerWeight() {
		//get id
		String inputWeight = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where WEIGHT like ?";
		String[] paras = new String[1];
		paras[0] = inputWeight;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerAVP() {
		//get id
		String inputAVP = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where AVP like ?";
		String[] paras = new String[1];
		paras[0] = inputAVP;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerAVR() {
		//get id
		String inputAVR = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where AVR like ?";
		String[] paras = new String[1];
		paras[0] = inputAVR;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerAVA() {
		//get id
		String inputAVA = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where AVA like ?";
		String[] paras = new String[1];
		paras[0] = inputAVA;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerTOP() {
		//get id
		String inputTOP = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where TOTALPOINTS like ?";
		String[] paras = new String[1];
		paras[0] = inputTOP;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerTOR() {
		//get id
		String inputTOR = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where TOTALREBOUND like ?";
		String[] paras = new String[1];
		paras[0] = inputTOR;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SearchLikePlayerTOA() {
		//get id
		String inputTOA = txtSearch.getText();
		Connect cnt = new Connect();
		String sql = "select * from NBA where TOTALASSIST like ?";
		String[] paras = new String[1];
		paras[0] = inputTOA;
		
				
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryLikeExecute(sql, paras);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void OrderByHeight() {
		Connect cnt = new Connect();
		String sql = "select * from NBA order by HEIGHT DESC";
		
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OrderByWeight() {
		Connect cnt = new Connect();
		String sql = "select * from NBA order by WEIGHT DESC";
		
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OrderByAVP() {
		Connect cnt = new Connect();
		String sql = "select * from NBA order by AVP DESC";
		
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OrderByAVR() {
		Connect cnt = new Connect();
		String sql = "select * from NBA order by AVR DESC";
		
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OrderByAVA() {
		Connect cnt = new Connect();
		String sql = "select * from NBA order by AVA DESC";
		
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OrderByTOP() {
		Connect cnt = new Connect();
		String sql = "select * from NBA order by TOTALPOINTS DESC";
		
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OrderByTOR() {
		Connect cnt = new Connect();
		String sql = "select * from NBA order by TOTALREBOUND DESC";
		
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OrderByTOA() {
		Connect cnt = new Connect();
		String sql = "select * from NBA order by TOTALASSIST DESC";
		
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				Tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				TableFirstName.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				TableLastName.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				TableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				TableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				TableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				TableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				TableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				TableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				TableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				TableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableEdit.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void EditPlayerid() {
		String id = TableEdit.getSelectionModel().getSelectedItem().getPlayerid().getValue();
		Connect cnt = new Connect();
		String sql = "update NBA set ID = ? where ID = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = id;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerFirstName() {
		String FN = TableEdit.getSelectionModel().getSelectedItem().getPlayerFirstName().getValue();
		Connect cnt = new Connect();
		String sql = "update NBA set FIRSTNAME = ? where FIRSTNAME = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = FN;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerLastName() {
		String LN = TableEdit.getSelectionModel().getSelectedItem().getPlayerLastName().getValue();
		Connect cnt = new Connect();
		String sql = "update NBA set LASTNAME = ? where LASTNAME = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = LN;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerHeight() {
		String Height = TableEdit.getSelectionModel().getSelectedItem().getPlayerHeight().getValue().toString();
		Connect cnt = new Connect();
		String sql = "update NBA set HEIGHT = ? where HEIGHT = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = Height;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerWeight() {
		String Weight = TableEdit.getSelectionModel().getSelectedItem().getPlayerWeight().getValue().toString();
		Connect cnt = new Connect();
		String sql = "update NBA set WEIGHT = ? where WEIGHT = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = Weight;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerAVP() {
		String AVP = TableEdit.getSelectionModel().getSelectedItem().getPlayerAVP().getValue().toString();
		Connect cnt = new Connect();
		String sql = "update NBA set AVP = ? where AVP = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = AVP;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerAVR() {
		String AVR = TableEdit.getSelectionModel().getSelectedItem().getPlayerAVR().getValue().toString();
		Connect cnt = new Connect();
		String sql = "update NBA set AVR = ? where AVR = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = AVR;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerAVA() {
		String AVA = TableEdit.getSelectionModel().getSelectedItem().getPlayerAVA().getValue().toString();
		Connect cnt = new Connect();
		String sql = "update NBA set AVA = ? where AVA = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = AVA;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerTOP() {
		String TOP = TableEdit.getSelectionModel().getSelectedItem().getPlayerTOTALPOINTS().getValue().toString();
		Connect cnt = new Connect();
		String sql = "update NBA set TOTALPOINTS = ? where TOTALPOINTS = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = TOP;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerTOR() {
		String TOR = TableEdit.getSelectionModel().getSelectedItem().getPlayerTOTALREBOUND().getValue().toString();
		Connect cnt = new Connect();
		String sql = "update NBA set TOTALREBOUND = ? where TOTALREBOUND = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = TOR;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
	
	public void EditPlayerTOA() {
		String TOA = TableEdit.getSelectionModel().getSelectedItem().getPlayerTOTALASSIST().getValue().toString();
		Connect cnt = new Connect();
		String sql = "update NBA set TOTALASSIST = ? where TOTALASSIST = ?";
		String[] paras = new String[2];
		paras[0] = txtSearch.getText().trim();
		paras[1] = TOA;
		if (cnt.updExecute(sql, paras)) {
			JOptionPane.showMessageDialog(null, "Player is updated");
	    }
	}
}
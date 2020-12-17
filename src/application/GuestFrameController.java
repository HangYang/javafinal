package application;

import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;

public class GuestFrameController {
	@FXML
	private AnchorPane PaneGuest;
	@FXML
	private MenuItem MenuMJ;
	@FXML
	private MenuItem MenuMelo;
	@FXML
	private MenuItem MenuJR;
	@FXML
	private MenuItem MenuJH;
	@FXML
	private MenuItem MenuLBJ;
	@FXML
	private MenuItem MenuKB;
	@FXML
	private AnchorPane PaneJH;
	@FXML
	private TableView<Player> TableJH;
	@FXML
	private TableColumn<Player, String> JHID;
	@FXML
	private TableColumn<Player, String> JHFN;
	@FXML
	private TableColumn<Player, String> JHLN;
	@FXML
	private TableColumn<Player, Double> JHHeight;
	@FXML
	private TableColumn<Player, Double> JHWeight;
	@FXML
	private TableColumn<Player, Double> JHAVP;
	@FXML
	private TableColumn<Player, Double> JHAVR;
	@FXML
	private TableColumn<Player, Double> JHAVA;
	@FXML
	private TableColumn<Player, Integer> JHTOP;
	@FXML
	private TableColumn<Player, Integer> JHTOR;
	@FXML
	private TableColumn<Player, Integer> JHTOA;
	@FXML
	private Button btGetJH;
	@FXML
	private AnchorPane PaneKB;
	@FXML
	private TableView<Player> TableKB;
	@FXML
	private TableColumn<Player, String> KBID;
	@FXML
	private TableColumn<Player, String> KBFN;
	@FXML
	private TableColumn<Player, String> KBLN;
	@FXML
	private TableColumn<Player, Double> KBHeight;
	@FXML
	private TableColumn<Player, Double> KBWeight;
	@FXML
	private TableColumn<Player, Double> KBAVP;
	@FXML
	private TableColumn<Player, Double> KBAVR;
	@FXML
	private TableColumn<Player, Double> KBAVA;
	@FXML
	private TableColumn<Player, Integer> KBTOP;
	@FXML
	private TableColumn<Player, Integer> KBTOR;
	@FXML
	private TableColumn<Player, Integer> KBTOA;
	@FXML
	private Button btGetKB;
	@FXML
	private AnchorPane PaneLBJ;
	@FXML
	private TableView<Player> TableLBJ;
	@FXML
	private TableColumn<Player, String> LBJID;
	@FXML
	private TableColumn<Player, String> LBJFN;
	@FXML
	private TableColumn<Player, String> LBJLN;
	@FXML
	private TableColumn<Player, Double> LBJHeight;
	@FXML
	private TableColumn<Player, Double> LBJWeight;
	@FXML
	private TableColumn<Player, Double> LBJAVP;
	@FXML
	private TableColumn<Player, Double> LBJAVR;
	@FXML
	private TableColumn<Player, Double> LBJAVA;
	@FXML
	private TableColumn<Player, Integer> LBJTOP;
	@FXML
	private TableColumn<Player, Integer> LBJTOR;
	@FXML
	private TableColumn<Player, Integer> LBJTOA;
	@FXML
	private Button btGetLBJ;
	@FXML
	private AnchorPane PaneJR;
	@FXML
	private TableView<Player> TableJR;
	@FXML
	private TableColumn<Player, String> JRID;
	@FXML
	private TableColumn<Player, String> JRFN;
	@FXML
	private TableColumn<Player, String> JRLN;
	@FXML
	private TableColumn<Player, Double> JRHeight;
	@FXML
	private TableColumn<Player, Double> JRWeight;
	@FXML
	private TableColumn<Player, Double> JRAVP;
	@FXML
	private TableColumn<Player, Double> JRAVR;
	@FXML
	private TableColumn<Player, Double> JRAVA;
	@FXML
	private TableColumn<Player, Integer> JRTOP;
	@FXML
	private TableColumn<Player, Integer> JRTOR;
	@FXML
	private TableColumn<Player, Integer> JRTOA;
	@FXML
	private Button btGetJR;
	@FXML
	private AnchorPane PaneMelo;
	@FXML
	private TableView<Player> TableMelo;
	@FXML
	private TableColumn<Player, String> MELOID;
	@FXML
	private TableColumn<Player, String> MELOFN;
	@FXML
	private TableColumn<Player, String> MELOLN;
	@FXML
	private TableColumn<Player, Double> MELOHeight;
	@FXML
	private TableColumn<Player, Double> MELOWeight;
	@FXML
	private TableColumn<Player, Double> MELOAVP;
	@FXML
	private TableColumn<Player, Double> MELOAVR;
	@FXML
	private TableColumn<Player, Double> MELOAVA;
	@FXML
	private TableColumn<Player, Integer> MELOTOP;
	@FXML
	private TableColumn<Player, Integer> MELOTOR;
	@FXML
	private TableColumn<Player, Integer> MELOTOA;
	@FXML
	private Button btGetMelo;
	@FXML
	private AnchorPane PaneMJ;
	@FXML
	private TableView<Player> TableMJ;
	@FXML
	private TableColumn<Player, String> MJID;
	@FXML
	private TableColumn<Player, String> MJFN;
	@FXML
	private TableColumn<Player, String> MJLN;
	@FXML
	private TableColumn<Player, Double> MJHeight;
	@FXML
	private TableColumn<Player, Double> MJWeight;
	@FXML
	private TableColumn<Player, Double> MJAVP;
	@FXML
	private TableColumn<Player, Double> MJAVR;
	@FXML
	private TableColumn<Player, Double> MJAVA;
	@FXML
	private TableColumn<Player, Integer> MJTOP;
	@FXML
	private TableColumn<Player, Integer> MJTOR;
	@FXML
	private TableColumn<Player, Integer> MJTOA;
	@FXML
	private Button btGetMJ;
	@FXML
	private AnchorPane PaneComparePlayer;
	@FXML
	private TableView<Player> TableCompare;
	@FXML
	private TableColumn<Player,String> tableid;
	@FXML
	private TableColumn<Player,String> tableFN;
	@FXML
	private TableColumn<Player,String> tableLN;
	@FXML
	private TableColumn<Player,Double> tableHeight;
	@FXML
	private TableColumn<Player,Double> tableWeight;
	@FXML
	private TableColumn<Player,Double> tableAVP;
	@FXML
	private TableColumn<Player,Double> tableAVR;
	@FXML
	private TableColumn<Player,Double> tableAVA;
	@FXML
	private TableColumn<Player,Integer> tableTOP;
	@FXML
	private TableColumn<Player,Integer> tableTOR;
	@FXML
	private TableColumn<Player,Integer> tableTOA;
	@FXML
	private AnchorPane PaneHelp;
	@FXML
	private TextField txtAdvice;
	@FXML
	private Button btSend;
	@FXML
	private AnchorPane PanePersonal;
	@FXML
	private Label lblusername;
	@FXML
	private Label lblDate;
	@FXML
	private AnchorPane PaneChangePassword;
	@FXML
	private Button btConfirm;
	@FXML
	private Button btCancelChange;
	@FXML
	private TextField txtChangeUsername;
	@FXML
	private TextField txtOldPassword;
	@FXML
	private TextField txtChangePassword;
	
	private final ObservableList<Player> cellData = FXCollections.observableArrayList();
	
	public void Home() {
		PaneGuest.setVisible(true);
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(false);
		PaneChangePassword.setVisible(false);
	}
	
	public void JH() {
		PaneJH.setVisible(true);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(false);
		PaneChangePassword.setVisible(false);
	}
	
	public void SearchJH() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where LASTNAME = 'Harden'";
		
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				JHID.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				JHFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				JHLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				JHHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				JHWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				JHAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				JHAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				JHAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				JHTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				JHTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				JHTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableJH.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void LBJ() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(true);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(false);
		PaneChangePassword.setVisible(false);
	}
	
	public void SearchLBJ() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'Lebron'";
		
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				LBJID.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				LBJFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				LBJLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				LBJHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				LBJWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				LBJAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				LBJAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				LBJAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				LBJTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				LBJTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				LBJTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableLBJ.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void MJ() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(true);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(false);
		PaneChangePassword.setVisible(false);
	}
	
	public void SearchMJ() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'Micheal'";
		
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				MJID.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				MJFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				MJLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				MJHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				MJWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				MJAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				MJAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				MJAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				MJTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				MJTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				MJTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableMJ.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void KB() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(true);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(false);
		PaneChangePassword.setVisible(false);
	}
	
	public void SearchKB() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'Kobe'";
		
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				KBID.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				KBFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				KBLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				KBHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				KBWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				KBAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				KBAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				KBAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				KBTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				KBTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				KBTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableKB.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void JR() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(true);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(false);
		PaneChangePassword.setVisible(false);
	}
	
	public void SearchJR() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'JR'";
		
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				JRID.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				JRFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				JRLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				JRHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				JRWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				JRAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				JRAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				JRAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				JRTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				JRTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				JRTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableJR.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Melo() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(true);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(false);
		PaneChangePassword.setVisible(false);
	}
	
	public void SearchMelo() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'Carmelo'";
		
		//Clean up
		cellData.clear();
		
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				MELOID.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				MELOFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				MELOLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				MELOHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				MELOWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				MELOAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				MELOAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				MELOAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				MELOTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				MELOTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				MELOTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
			
			TableMelo.setItems(cellData);
			cnt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Help() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(true);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(false);
		PaneChangePassword.setVisible(false);
	}
	
	public void Send() {
        String advice = txtAdvice.getText().trim();
		
		String sql = "insert into About(Advice) values(?)";
		
		String[] paras = new String[1];
		paras[0] = advice;
		
		Connect cnt = new Connect();
		boolean r = cnt.updExecute(sql, paras);
		if (r) {
			JOptionPane.showMessageDialog(null, "Succeed Send");
		}
	}
	
	public void Jordan() {
		new MediaDemo();
	}
	
	public void ComparePlayer() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(true);
		PanePersonal.setVisible(false);
		PaneChangePassword.setVisible(false);
	}
	
	public void Harden() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where LASTNAME = 'Harden'";
			
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				tableFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				tableLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				tableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				tableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				tableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				tableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				tableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				tableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				tableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				tableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
					
			TableCompare.setItems(cellData);
			cnt.close();
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Lebron() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'Lebron'";
					
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				tableFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				tableLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				tableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				tableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				tableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				tableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				tableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				tableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				tableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				tableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
							
			TableCompare.setItems(cellData);
			cnt.close();
							
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Micheal() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'Micheal'";
							
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				tableFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				tableLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				tableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				tableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				tableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				tableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				tableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				tableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				tableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				tableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
									
			TableCompare.setItems(cellData);
			cnt.close();
									
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Kobe() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'Kobe'";
							
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				tableFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				tableLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				tableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				tableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				tableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				tableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				tableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				tableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				tableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				tableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
									
			TableCompare.setItems(cellData);
			cnt.close();
									
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Smith() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'JR'";
							
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				tableFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				tableLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				tableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				tableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				tableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				tableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				tableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				tableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				tableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				tableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
									
			TableCompare.setItems(cellData);
			cnt.close();
									
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Carmelo() {
		//get id
		Connect cnt = new Connect();
		String sql = "select * from NBA where FIRSTNAME = 'Carmelo'";
							
		try {
			ResultSet rs = cnt.queryExcecute(sql);
			while(rs.next()) {
				cellData.add(new Player(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
				tableid.setCellValueFactory(cellData -> cellData.getValue().getPlayerid());
				tableFN.setCellValueFactory(cellData -> cellData.getValue().getPlayerFirstName());
				tableLN.setCellValueFactory(cellData -> cellData.getValue().getPlayerLastName());
				tableHeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerHeight().asObject());
				tableWeight.setCellValueFactory(cellData -> cellData.getValue().getPlayerWeight().asObject());
				tableAVP.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVP().asObject());
				tableAVR.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVR().asObject());
				tableAVA.setCellValueFactory(cellData -> cellData.getValue().getPlayerAVA().asObject());
				tableTOP.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALPOINTS().asObject());
				tableTOR.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALREBOUND().asObject());
				tableTOA.setCellValueFactory(cellData -> cellData.getValue().getPlayerTOTALASSIST().asObject());
			}
									
			TableCompare.setItems(cellData);
			cnt.close();
									
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clear() {
		cellData.clear();
	}
	
	public void delete() {
		cellData.remove(TableCompare.getSelectionModel().getSelectedItem());
	}
	
	public void Personal() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(true);
		PaneChangePassword.setVisible(false);
	}
	public void getuserName() {
		lblusername.setText(LoginController.userName);
	}
	
	public void getDate() {
		lblDate.setText(new Date().toString());
	}
	
	public void ChangePassword() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(true);
		PaneChangePassword.setVisible(true);
	}
	
	public void Confirm() {
		String inputusername = txtChangeUsername.getText().trim();
		String oldpassword = txtOldPassword.getText().trim();
		
		if(inputusername == LoginController.userName && oldpassword == LoginController.password) {
			String sql = "update Guest set PassWord = ? Where UserName = ?";
			Connect cnt = new Connect();
			String[] paras = new String[2];
			paras[0] = txtChangePassword.getText().trim();
			paras[1] = LoginController.userName;
			if (cnt.updExecute(sql, paras)) {
				System.out.println("Password is Changed");
			}
		}
	}
	
	public void CancelinChangePassword() {
		PaneJH.setVisible(false);
		PaneLBJ.setVisible(false);
		PaneJR.setVisible(false);
		PaneKB.setVisible(false);
		PaneMelo.setVisible(false);
		PaneMJ.setVisible(false);
		PaneHelp.setVisible(false);
		PaneComparePlayer.setVisible(false);
		PanePersonal.setVisible(true);
		PaneChangePassword.setVisible(false);
	}
}

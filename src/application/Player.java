package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
	private StringProperty Playerid;
	private StringProperty PlayerFirstName;
	private StringProperty PlayerLastName;
	private DoubleProperty PlayerHeight;
	private DoubleProperty PlayerWeight;
	private DoubleProperty PlayerAVP;
	private DoubleProperty PlayerAVR;
	private DoubleProperty PlayerAVA;
	private IntegerProperty PlayerTOTALPOINTS;
	private IntegerProperty PlayerTOTALREBOUND;
	private IntegerProperty PlayerTOTALASSIST;
	
	public Player(String Playerid, String PlayerFirstName, String PlayerLastName,
			Double PlayerHeight, Double PlayerWeight, Double PlayerAVP, Double PlayerAVR, Double PlayerAVA,
			Integer PlayerTOTALPOINTS, Integer PlayerTOTALREBOUND, Integer PlayerTOTALASSIST) {
		super();
		this.Playerid = new SimpleStringProperty(Playerid);
		this.PlayerFirstName = new SimpleStringProperty(PlayerFirstName);
		this.PlayerLastName = new SimpleStringProperty(PlayerLastName);
		this.PlayerHeight = new SimpleDoubleProperty(PlayerHeight);
		this.PlayerWeight = new SimpleDoubleProperty(PlayerWeight);
		this.PlayerAVP = new SimpleDoubleProperty(PlayerAVP);
		this.PlayerAVR = new SimpleDoubleProperty(PlayerAVR);
		this.PlayerAVA = new SimpleDoubleProperty(PlayerAVA);
		this.PlayerTOTALPOINTS = new SimpleIntegerProperty(PlayerTOTALPOINTS);
		this.PlayerTOTALREBOUND = new SimpleIntegerProperty(PlayerTOTALREBOUND);
		this.PlayerTOTALASSIST = new SimpleIntegerProperty(PlayerTOTALASSIST);
	}

	public StringProperty getPlayerid() {
		return Playerid;
	}

	public void setPlayerid(String playerid) {
		this.Playerid = new SimpleStringProperty(playerid);
	}

	public StringProperty getPlayerFirstName() {
		return PlayerFirstName;
	}

	public void setPlayerFirstName(String playerFirstName) {
		this.PlayerFirstName = new SimpleStringProperty(playerFirstName);
	}

	public StringProperty getPlayerLastName() {
		return PlayerLastName;
	}

	public void setPlayerLastName(String playerLastName) {
		this.PlayerLastName = new SimpleStringProperty(playerLastName);
	}

	public DoubleProperty getPlayerHeight() {
		return PlayerHeight;
	}

	public void setPlayerHeight(Double playerHeight) {
		this.PlayerHeight = new SimpleDoubleProperty(playerHeight);
	}

	public DoubleProperty getPlayerWeight() {
		return PlayerWeight;
	}

	public void setPlayerWeight(Double playerWeight) {
		this.PlayerWeight = new SimpleDoubleProperty(playerWeight);
	}

	public DoubleProperty getPlayerAVP() {
		return PlayerAVP;
	}

	public void setPlayerAVP(Double playerAVP) {
		this.PlayerAVP = new SimpleDoubleProperty(playerAVP);
	}

	public DoubleProperty getPlayerAVR() {
		return PlayerAVR;
	}

	public void setPlayerAVR(Double playerAVR) {
		this.PlayerAVR = new SimpleDoubleProperty(playerAVR);
	}

	public DoubleProperty getPlayerAVA() {
		return PlayerAVA;
	}

	public void setPlayerAVA(Double playerAVA) {
		this.PlayerAVA = new SimpleDoubleProperty(playerAVA);
	}

	public IntegerProperty getPlayerTOTALPOINTS() {
		return PlayerTOTALPOINTS;
	}

	public void setPlayerTOTALPOINTS(Integer playerTOTALPOINTS) {
		this.PlayerTOTALPOINTS = new SimpleIntegerProperty(playerTOTALPOINTS);
	}

	public IntegerProperty getPlayerTOTALREBOUND() {
		return PlayerTOTALREBOUND;
	}

	public void setPlayerTOTALREBOUND(Integer playerTOTALREBOUND) {
		this.PlayerTOTALREBOUND = new SimpleIntegerProperty(playerTOTALREBOUND);
	}

	public IntegerProperty getPlayerTOTALASSIST() {
		return PlayerTOTALASSIST;
	}

	public void setPlayerTOTALASSIST(Integer playerTOTALASSIST) {
		this.PlayerTOTALASSIST = new SimpleIntegerProperty(playerTOTALASSIST);
	}
	
	
}

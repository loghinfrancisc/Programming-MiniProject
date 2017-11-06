import java.io.Serializable;

//this is the server packet
public class Packet implements Serializable {
	//Lobby
	public String lobbyMSG=""; 
	int firstGameState=99;
	int secondGameState=99;
	boolean updateLobby=false;
	
	//Game class
	public String packetCMD=""; 
	public int gameCommand=99;
	public int gameNo=99;
	public int squareNo=99;
	int playerNO=99;
	//Game Checker class
	public String gameCheckerCommand="";
}

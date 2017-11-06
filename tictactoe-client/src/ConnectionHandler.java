import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionHandler extends Thread{//this class will be used to handle all connections, it will contain a send function called
	//by the main class whenever the packet needs to be sent to the server, and it will check for incoming packets on its own thread
	static Socket socket;
	static int gameNO;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;
	static Packet incoming;
	static Packet output;
	static boolean createdOne;
	static boolean createdTwo;
	static boolean inGame=false;
	public void send() {
		try {
			oos.reset();
			output.gameNo=gameNO;
			System.out.println(gameNO);
			System.out.println(output.gameCheckerCommand);
			oos.writeObject(output);
			output=new Packet();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			socket=new Socket("localhost", 7007);
			oos=new ObjectOutputStream(socket.getOutputStream());
			ois=new ObjectInputStream(socket.getInputStream());
			output=new Packet();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	while(true) {
	try {
		incoming=(Packet) ois.readObject();
		System.out.println("received packet");
		System.out.println(incoming.packetCMD);
	} catch (Exception e) {
		e.printStackTrace();
	}
	if(inGame==false){
	if(incoming.lobbyMSG.startsWith("CREATED_1")){
		System.out.println("created da ting");
		createdOne=true;
	}
	else if(incoming.lobbyMSG.startsWith("CREATED_2")){
		createdTwo=true;
	}
	else if(incoming.lobbyMSG.startsWith("STARTED_1")){
		inGame=true;
		gameNO=incoming.gameNo;
		Main.startGame(1);
		
	}
	else if(incoming.lobbyMSG.startsWith("STARTED_2")){
		inGame=true;
		gameNO=incoming.gameNo;
		Main.startGame(2);
	}
	else if(incoming.lobbyMSG.startsWith("CLOSED_1")){
		createdOne=false;
	}
	else if(incoming.lobbyMSG.startsWith("CLOSED_2")){
		createdTwo=false;
	}
	if(incoming.updateLobby==true){
		String[] tmp=new String[6];
		if(incoming.firstGameState==0){
			tmp[0]="Empty Game";
			tmp[1]="0/2";
			tmp[2]="Create Game";
		}
		if(incoming.firstGameState==1&&createdOne==false){
			tmp[0]="Game #1";
			tmp[1]="1/2";
			tmp[2]="Join Game";
		}
		if(incoming.firstGameState==1&&createdOne==true){
			tmp[0]="Game #1";
			tmp[1]="1/2";
			tmp[2]="Close Game";
		}
		if(incoming.firstGameState==2){
			tmp[0]="Game #1";
			tmp[1]="2/2";
			tmp[2]="Game is full";
		}
		if(incoming.secondGameState==0){
			tmp[3]="Empty Game";
			tmp[4]="0/2";
			tmp[5]="Create Game";
		}
		if(incoming.secondGameState==1&&createdOne==false){
			tmp[3]="Game #2";
			tmp[4]="1/2";
			tmp[5]="Join Game";
		}
		if(incoming.secondGameState==1&&createdOne==true){
			tmp[3]="Game #2";
			tmp[4]="1/2";
			tmp[5]="Close Game";
		}
		if(incoming.secondGameState==2){
			tmp[3]="Game #2";
			tmp[4]="2/2";
			tmp[5]="Game is full";
		}
		Main.updateLobby(tmp, incoming.firstGameState, incoming.secondGameState);
	}
	}
	else if(incoming.packetCMD.startsWith("LOSE")){
		Main.end("YOU LOST");
	}
	else if(incoming.packetCMD.startsWith("TIE")){
		Main.end("YOU TIED");
	}
	else if(incoming.packetCMD.startsWith("OPPONENT_MOVE")){
		Main.opponentMove(incoming.squareNo);
	}
	incoming=new Packet();
	//need to code a response for what needs to be done when a certain command has been made by the server
	}
}
	
}

import java.net.*;
import java.io.*;
//WIP, should be kind of correct, we will see how it behaves with the actual client
public class Client extends Thread{
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	volatile Packet incoming;
	volatile Packet output;
Client(Socket sock){
	socket=sock;
	try {
		oos=new ObjectOutputStream(socket.getOutputStream());
		ois=new ObjectInputStream(socket.getInputStream());
		output=new Packet();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void send() {
	try {
		oos.reset();
		System.out.println(output.packetCMD);
		oos.writeObject(output);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void run() {
	output.updateLobby=true;
	output.firstGameState=Lobby.firstGameState;
	output.secondGameState=Lobby.secondGameState;
	send();
	while(true) {// always read for incoming objects
		try {
			incoming=(Packet) ois.readObject();// the thread will wait here until it receives an object
			System.out.println(incoming.gameCheckerCommand);
			System.out.println(incoming.gameNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
if(incoming.lobbyMSG.startsWith("CREATE_GAME_1")) {//create a game
	Lobby.createGame(this, 1);
}
else if(incoming.lobbyMSG.startsWith("JOIN_GAME_1")) {// join a game
	Lobby.joinGame(this, 1);
}
else if(incoming.lobbyMSG.startsWith("CLOSE_GAME_1")) { //close a game
	Lobby.closeGame(this, 1);
}
else if(incoming.lobbyMSG.startsWith("CREATE_GAME_2")) {//create a game
	Lobby.createGame(this, 2);
}
else if(incoming.lobbyMSG.startsWith("JOIN_GAME_2")) {// join a game
	Lobby.joinGame(this, 2);
}
else if(incoming.lobbyMSG.startsWith("CLOSE_GAME_2")) { //close a game
	Lobby.closeGame(this, 2);
}
else if(incoming.gameCheckerCommand.startsWith("WIN")&&incoming.gameNo==1){
	Lobby.firstGame.conditionListener(incoming.gameCheckerCommand, incoming.squareNo, this);
}
else if(incoming.gameCheckerCommand.startsWith("TIE")&&incoming.gameNo==1){
	Lobby.firstGame.conditionListener(incoming.gameCheckerCommand, incoming.squareNo, this);
}
else if(incoming.gameCheckerCommand.startsWith("MOVE")&&incoming.gameNo==1){
	Lobby.firstGame.conditionListener(incoming.gameCheckerCommand, incoming.squareNo, this);
}
else if(incoming.gameCheckerCommand.startsWith("WIN")&&incoming.gameNo==2){
	Lobby.secondGame.conditionListener(incoming.gameCheckerCommand, incoming.squareNo, this);
}
else if(incoming.gameCheckerCommand.startsWith("TIE")&&incoming.gameNo==2){
	Lobby.secondGame.conditionListener(incoming.gameCheckerCommand, incoming.squareNo, this);
}
else if(incoming.gameCheckerCommand.startsWith("MOVE")&&incoming.gameNo==2){
	Lobby.secondGame.conditionListener(incoming.gameCheckerCommand, incoming.squareNo, this);
}
incoming=new Packet();
}

}
}

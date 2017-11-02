import java.net.*;
import java.io.*;
//WIP, should be kind of correct, we will see how it behaves with the actual client
public class Client extends Thread{
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	static int gameNo=0;
	boolean inGame=false;
	Packet incoming;
	Packet output;
Client(Socket sock){
	socket=sock;
	try {
		ois=new ObjectInputStream(socket.getInputStream());
		oos=new ObjectOutputStream(socket.getOutputStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void opponentMoved(int square) {
	output.squareNo=square;
	try {
		oos.writeObject(output);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void run() {
	while(true) {// always read for incoming objects
		try {
			incoming=(Packet) ois.readObject();// the thread will wait here until it receives an object
		} catch (Exception e) {
			e.printStackTrace();
		}
if(inGame==false) {// if the user is not inGame(is in the lobby)
if(incoming.lobbyCommand==1) {//create a game
	Lobby.createGame(this);
}
else if(incoming.lobbyCommand==2) {// join a game
	Lobby.joinGame(this, incoming.gameNo);
}
else if(incoming.lobbyCommand==3) { //close a game
	Lobby.closeGame(this, incoming.gameNo);
}

}
else {//if he is in a game
	if(incoming.gameCommand==1) {//and requests to move
		if(gameNo==1) {//if he is in game number one
//old			if(Lobby.firstGame.allowedMove(incoming.squareNo, this)) {//if the move is allowed, the move will be performed by that function
//old				if(Lobby.firstGame.win()) {//if there is a winner
					//declare victory
				}
//old				else if(Lobby.firstGame.boardFilled()) {
					//declare tie game
//				}
//			}
//		}
		else if(gameNo==2) {//if he is in game number one
//old			if(Lobby.secondGame.allowedMove(incoming.squareNo, this)) {//if the move is allowed, the move will be performed by that function
//old				if(Lobby.secondGame.win()) {//if there is a winner
					//declare victory
				}
//old				else if(Lobby.secondGame.boardFilled()) {
					//declare tie game
				}
			}
		}
//	}
//}
//}
}
}

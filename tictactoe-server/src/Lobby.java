//NOT FULLY PLANNED OUT YET
public class Lobby {
	static Client[] waitingForGame= {null,null,null,null}; //null spaces for clients to join games. 0, 1 = game #1, 2, 3 = game #2
	static Game firstGame=null;
	static Game secondGame=null;
	static int firstGameState=0;
	static int secondGameState=0;
	public static void createGame(Client player, int gameNO) {// called when the client requests to create a game
	if(waitingForGame[0] == null&&gameNO==1) {// if the first game is not created(no user in this slot)
		waitingForGame[0] = player; // assign user to this slot
		player.output.lobbyMSG="CREATED_1";
		firstGameState=1;
		player.send();
	}
	else if(waitingForGame[2] == null&&gameNO==2) {// else if first game was already created, but the second slot is open
		waitingForGame[2] = player;//assign him to a second game
		player.output.lobbyMSG="CREATED_2";
		secondGameState=1;
		player.send();
	}
	else if((waitingForGame[0] != null) && (waitingForGame[2] != null)){
		//tell the client that maximum allowed amount of games(2) have been created. Please join an existing game.
		player.output.lobbyMSG="FAILED_CREATE";
		player.send();
	}
	if(Server.cl1!=null){
		Server.cl1.output.updateLobby=true;
		Server.cl1.output.firstGameState=firstGameState;
		Server.cl1.output.secondGameState=secondGameState;
		Server.cl1.send();
	}
	if(Server.cl2!=null){
		Server.cl2.output.updateLobby=true;
		Server.cl2.output.firstGameState=firstGameState;
		Server.cl2.output.secondGameState=secondGameState;
		Server.cl2.send();
	}
	if(Server.cl3!=null){
		Server.cl3.output.updateLobby=true;
		Server.cl3.output.firstGameState=firstGameState;
		Server.cl3.output.secondGameState=secondGameState;
		Server.cl3.send();
	}
	if(Server.cl4!=null){
		Server.cl4.output.updateLobby=true;
		Server.cl4.output.firstGameState=firstGameState;
		Server.cl4.output.secondGameState=secondGameState;
		Server.cl4.send();
	}
	}
	public static void joinGame(Client player, int no) { // join game
		if(no == 1) {// player wants to join game no 1
			if(waitingForGame[1] == null) {// if the slot is open
				waitingForGame[1] = player;// assign the user to that slot
				firstGame = new Game(waitingForGame[0], waitingForGame[1],1); // and start a game with those clients - this is where the game obejct is created
				firstGameState=2;
				waitingForGame[0].output.lobbyMSG="STARTED_1";
				waitingForGame[1].output.lobbyMSG="STARTED_2";
				waitingForGame[0].output.gameNo=1;
				waitingForGame[1].output.gameNo=1;
				waitingForGame[0].send();
				waitingForGame[1].send();
				firstGame.start();
			}
		}
		else if(no == 2) {//player wants to join game no 2
			if(waitingForGame[3] == null) {// if the spot is open
				waitingForGame[3] = player;// assign him
				secondGame=new Game(waitingForGame[2], waitingForGame[3],2);//start the game
				secondGameState=2;
				waitingForGame[2].output.lobbyMSG="STARTED_1";
				waitingForGame[3].output.lobbyMSG="STARTED_2";
				waitingForGame[2].output.gameNo=2;
				waitingForGame[3].output.gameNo=2;
				waitingForGame[2].send();
				waitingForGame[3].send();
				secondGame.start();
			}
			else {
				//tell the client that he is unable to join the game
				player.output.lobbyMSG="FAILED_JOIN";
				player.send(); // sends back message to client 
			}
		}
		if(Server.cl1!=null){
			Server.cl1.output.updateLobby=true;
			Server.cl1.output.firstGameState=firstGameState;
			Server.cl1.output.secondGameState=secondGameState;
			Server.cl1.send();
		}
		if(Server.cl2!=null){
			Server.cl2.output.updateLobby=true;
			Server.cl2.output.firstGameState=firstGameState;
			Server.cl2.output.secondGameState=secondGameState;
			Server.cl2.send();
		}
		if(Server.cl3!=null){
			Server.cl3.output.updateLobby=true;
			Server.cl3.output.firstGameState=firstGameState;
			Server.cl3.output.secondGameState=secondGameState;
			Server.cl3.send();
		}
		if(Server.cl4!=null){
			Server.cl4.output.updateLobby=true;
			Server.cl4.output.firstGameState=firstGameState;
			Server.cl4.output.secondGameState=secondGameState;
			Server.cl4.send();
		}
	}
	public static void closeGame(Client player, int no) {// if a user wants to close a game
		if(no == 1 && waitingForGame[0] == player) {// if he wants to close the first game, and is indeed the creator of that
			waitingForGame[0] = null;// remove him from the slot
			player.output.lobbyMSG="CLOSED_1";
			firstGameState=0;
			player.send();
		}
		else if(no == 2 && waitingForGame[2] == player) {// same here
			waitingForGame[2] = null;
			player.output.lobbyMSG="CLOSED_2";
			secondGameState=0;
			player.send();
		}
		if(Server.cl1!=null){
			Server.cl1.output.updateLobby=true;
			Server.cl1.output.firstGameState=firstGameState;
			Server.cl1.output.secondGameState=secondGameState;
			Server.cl1.send();
		}
		if(Server.cl2!=null){
			Server.cl2.output.updateLobby=true;
			Server.cl2.output.firstGameState=firstGameState;
			Server.cl2.output.secondGameState=secondGameState;
			Server.cl2.send();
		}
		if(Server.cl3!=null){
			Server.cl3.output.updateLobby=true;
			Server.cl3.output.firstGameState=firstGameState;
			Server.cl3.output.secondGameState=secondGameState;
			Server.cl3.send();
		}
		if(Server.cl4!=null){
			Server.cl4.output.updateLobby=true;
			Server.cl4.output.firstGameState=firstGameState;
			Server.cl4.output.secondGameState=secondGameState;
			Server.cl4.send();
		}
	}
	
}

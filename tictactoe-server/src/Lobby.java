//NOT FULLY PLANNED OUT YET
public class Lobby {
	static Client[] waitingForGame= {null,null,null,null}; //null spaces for clients to join games. 0, 1 = game #1, 2, 3 = game #2
	static Game firstGame=null;
	static Game secondGame=null;
	public static void createGame(Client player) {// called when the client requests to create a game
	if(waitingForGame[0] == null) {// if the first game is not created(no user in this slot)
		waitingForGame[0] = player; // assign user to this slot
	}
	else if(waitingForGame[2] == null) {// else if first game was already created, but the second slot is open
		waitingForGame[2] = player;//assign him to a second game
	}
	else if((waitingForGame[0] !== null) && (waitingForGame[2] !== null)){
		//tell the client that maximum allowed amount of games(2) have been created. Please join an existing game.
		player.output.lobbyMSG="FAILED_CREATE";
		player.send();
	}
	}
	public static void joinGame(Client player, int no) { // join game
		if(no == 1) {// player wants to join game no 1
			if(waitingForGame[1] == null) {// if the slot is open
				waitingForGame[1] = player;// assign the user to that slot
				firstGame = new Game(waitingForGame[0], waitingForGame[1]); // and start a game with those clients - this is where the game obejct is created
				waitingForGame[0].gameNo = 1;
				waitingForGame[1].gameNo = 1;
				firstGame.start();
			}
			else {
				//tell the client that he is unable to join game
				player.output.lobbyMSG="FAILED_JOIN";
				player.send();  // sends back message to client 
			}
		}
		else if(no == 2) {//player wants to join game no 2
			if(waitingForGame[3] == null) {// if the spot is open
				waitingForGame[3] = player;// assign him
				secondGame=new Game(waitingForGame[2], waitingForGame[3]);//start the game
				waitingForGame[2].gameNo = 2;
				waitingForGame[3].gameNo = 2;
				secondGame.start();
			}
			else {
				//tell the client that he is unable to join the game
				player.output.lobbyMSG="FAILED_JOIN";
				player.send(); // sends back message to client 
			}
		}
	}
	public static void closeGame(Client player, int no) {// if a user wants to close a game
		if(no == 1 && waitingForGame[0] == player) {// if he wants to close the first game, and is indeed the creator of that
			waitingForGame[0] = null;// remove him from the slot
		}
		else if(no == 2 && waitingForGame[2] == pl) {// same here
			waitingForGame[2] = null;
		}
	}
}

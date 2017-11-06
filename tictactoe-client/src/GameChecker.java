public class GameChecker{
public static boolean boardFilled(){
	for(int i=0;i<Main.board.length;i++){
		if (Main.board[i] == 0){
			return false;
		}
	}
return true;
}

public static boolean winCheck() {		
			for(int j = 0; j < Main.board.length; j++){//only one loop to check if this player has won. If the other player wins, it will send a message to the server
				//where the server will send a message to the other player. Meaning we dont need to check for both players
			if(Main.board[0] == Main.playerNo && Main.board[1] == Main.playerNo && Main.board[2] == Main.playerNo) // horizontal 1
			{
				return true;
			}
			
			else if(Main.board[3] == Main.playerNo && Main.board[4] == Main.playerNo && Main.board[5] == Main.playerNo) // horizontal 2
			{
				return true;
			}
			
			else if(Main.board[6] == Main.playerNo && Main.board[7] == Main.playerNo && Main.board[8] == Main.playerNo) // horizontal 3
			{
				return true;
			}
			
			else if(Main.board[0] == Main.playerNo && Main.board[4] == Main.playerNo && Main.board[8] == Main.playerNo) // diagonal 1
			{
				return true;
			}
			
			else if(Main.board[6] == Main.playerNo && Main.board[4] == Main.playerNo && Main.board[2] == Main.playerNo) // diagonal 2
			{
				return true;
			}
			
			else if(Main.board[0] == Main.playerNo && Main.board[3] == Main.playerNo && Main.board[6] == Main.playerNo) // vertical 1
			{
				return true;
			}
			
			else if(Main.board[1] == Main.playerNo && Main.board[4] == Main.playerNo && Main.board[7] == Main.playerNo) // vertical 2
			{
				return true;
			}
			
			else if(Main.board[2] == Main.playerNo && Main.board[5] == Main.playerNo && Main.board[8] == Main.playerNo) // vertical 3
			{
				return true;
			}
		}
return false;
	}
public static void allowedMove(int squareNo, boolean currentPlayer)
		{

		 if(currentPlayer && Main.board[squareNo]==0 && squareNo!=99)  // if conditions are true
			 {
			 Main.yourTurn=false;
			 Main.board[squareNo]=Main.playerNo;
			 Main.handler.output.squareNo=squareNo;
			 if(winCheck()){
				 Main.handler.output.gameCheckerCommand="WIN";
				 Main.end("YOU WIN");
			 }
			 else if(boardFilled()){
				 Main.handler.output.gameCheckerCommand="TIE";
				 Main.end("YOU TIED");
			 }
			 else{
				 Main.handler.output.gameCheckerCommand="MOVE";
			 }
			 Main.ownMove(squareNo);
			 Main.handler.send();
			 
			 }
	}
}

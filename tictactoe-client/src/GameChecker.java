import java.net.Socket;

public class GameChecker extends Main
{
	GameChecker(Socket sock) {
		super(sock);
		// TODO Auto-generated constructor stub
	}


	//transfered to client side
	//these functions will be called from the main class when a client will press buttons
	
	//initializing the board array for maja, so we don't get a billion errors
	private Client[] board = {null, null, null, null, null, null, null, null, null};
	
	//IS THE BOARD FILLED?

	//add a loop that checks through all of the board array values, and if any one of them is still null, return false. Otherwise, return true
	public boolean boardFilled(boolean fill) 
	{
			for(int i = 0; i < board.length; i++)
			{
				if (board[i] == null)
				{
				fill = false;
				break;
				}
			
				else
				{
					fill = true;
					break;
				}
			}
		return fill;	
	}
	

	//player1Win CONDITION

	//add if statements to check through all 8 possible player1Winning conditions in tic tac toe
	public boolean WinCheck(boolean player1Win, boolean player2Win) 
	{	
		for (int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)		
		{
			//checks if Player 1 wins 
			if(board[0] == pl1 && board[1] == pl1 && board[2] == pl1) // horizontal 1
			{
				player1Win = true;
				return player1Win;
			}
			
			else if(board[3] == pl1 && board[4] == pl1 && board[5] == pl1) // horizontal 2
			{
				player1Win = true;
				return player1Win;
			}
			
			if(board[6] == pl1 && board[7] == pl1 && board[8] == pl1) // horizontal 3
			{
				player1Win = true;
				return player1Win;
			}
			
			else if(board[0] == pl1 && board[4] == pl1 && board[8] == pl1) // diagonal 1
			{
				player1Win = true;
				return player1Win;
			}
			
			if(board[6] == pl1 && board[4] == pl1 && board[2] == pl1) // diagonal 2
			{
				player1Win = true;
				return player1Win;
			}
			
			else if(board[0] == pl1 && board[3] == pl1 && board[6] == pl1) // vertical 1
			{
				player1Win = true;
				return player1Win;
			}
			
			if(board[1] == pl1 && board[4] == pl1 && board[7] == pl1) // vertical 2
			{
				player1Win = true;
				return player1Win;
			}
			
			else if(board[2] == pl1 && board[5] == pl1 && board[8] == pl1) // vertical 3
			{
				player1Win = true;
				return player1Win;
			}	
			
			//checks if Player 2 wins 
			if(board[0] == pl2 && board[1] == pl2 && board[2] == pl2) // horizontal 1
			{
				player2Win = true;
				return player2Win;
			}
			
			else if(board[3] == pl2 && board[4] == pl2 && board[5] == pl2) // horizontal 2
			{
				player2Win = true;
				return player2Win;
			}
			
			if(board[6] == pl2 && board[7] == pl2 && board[8] == pl2) // horizontal 3
			{
				player2Win = true;
				return player2Win;
			}
			
			else if(board[0] == pl2 && board[4] == pl2 && board[8] == pl2) // diagonal 1
			{
				player2Win = true;
				return player2Win;
			}
			
			if(board[6] == pl2 && board[4] == pl2 && board[2] == pl2) // diagonal 2
			{
				player2Win = true;
				return player2Win;
			}
			
			else if(board[0] == pl2 && board[3] == pl2 && board[6] == pl2) // vertical 1
			{
				player2Win = true;
				return player2Win;
			}
			
			if(board[1] == pl2 && board[4] == pl2 && board[7] == pl2) // vertical 2
			{
				player2Win = true;
				return player2Win;
			}
			
			else if(board[2] == pl2 && board[5] == pl2 && board[8] == pl2) // vertical 3
			{
				player2Win = true;
				return player2Win;
			}
		}
			
	}
		
		
/*
	//ALLOWED MOVE


We also need to check if the move is allowed, when player clicks the squares. 
That is, we need to check, if the player is the currentPlayer 
and if the square is already taken.
if the move is allowed, perform action, which is, assign the selected square to
the currentPlayer, change the currentPlayer,
and call a function for the opponent that the currentPlayer moved

*/
	
	public boolean allowedMove(int squareNo, Client pl1)
	{
		 if(Main.yourTurn == true && squareNo == null )  // if conditions are true
		 {
			 board[squareNo] = pl1;
			 
			 //perform actions, 
			 
			 return true;
		 }
			 else
		 {
			 return false;
		 }
	}
}

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
	

	//WIN CONDITION

	//add if statements to check through all 8 possible winning conditions in tic tac toe
	public boolean winCheck(boolean win) 
	{
		//int boardState[] = {0,0,0,0,0,0,0,0,0}; not using ints but array of Clients instead
		
		for (int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)		
		{
			if(board[0] == pl1 && board[1] == pl1 && board[2] == pl1) // horizontal 1
			{
				win = true;
			}
			
			else if(board[3] == 1 && board[4] == 1 && board[5] == 1) // horizontal 2
			{
				win = true;
			}
			
			if(board[6] == 1 && board[7] == 1 && board[8] == 1) // horizontal 3
			{
				win = true;
			}
			
			else if(board[0] == 1 && board[4] == 1 && board[8] == 1) // diagonal 1
			{
				win = true;
			}
			
			if(board[6] == 1 && board[4] == 1 && board[2] == 1) // diagonal 2
			{
				win = true;
			}
			
			else if(board[0] == 1 && board[3] == 1 && board[6] == 1) // vertical 1
			{
				win = true;
			}
			
			if(board[1] == 1 && board[4] == 1 && board[7] == 1) // vertical 2
			{
				win = true;
			}
			
			else if(board[2] == 1 && board[5] == 1 && board[8] == 1) // vertical 3
			{
				win = true;
			}	
		}
		return win;	
	}
		
		

	//ALLOWED MOVE

	//We also need to check if the move is allowed, when player clicks the squares. That is, we need to check, if the player is the currentPlayer
	//and if the square is already taken.
	//if the move is allowed, perform action, which is, assign the selected square to the currentPlayer, change the currentPlayer,
	//and call a function for the opponent that the currentPlayer moved

		public boolean allowedMove(int squareNo, boolean currentPlayer)
		{
		 if(pl1 == isCurrentPlayer && squareNo == null )  // if conditions are true
			 {
			 isCurrentPlayer == true;
			 isCurrentPlayer = squareNo;
			 
			 //perform actions, 
			 
			 return true;
			 
			 }
			 else
			 {
			 return false;
			 }
		}
	}

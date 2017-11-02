import java.net.Socket;

public class GameChecker extends Client

{
	GameChecker(Socket sock) {
		super(sock);
		// TODO Auto-generated constructor stub
	}


	//transfered to client side
	//these functions will be called from the main class when a client will press buttons
	
	//initializing the board array for maja
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
		int boardState[] = {0,0,0};
		
		for (int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)		
		{
			if(boardState[0] == 1 && boardState[1] == 1 && boardState[2] == 1) // horizontal 1
			{
				win = true;
			}
			
			else if(boardState[3] == 1 && boardState[4] == 1 && boardState[5] == 1) // horizontal 2
			{
				win = true;
			}
			
			if(boardState[6] == 1 && boardState[7] == 1 && boardState[8] == 1) // horizontal 3
			{
				win = true;
			}
			
			else if(boardState[0] == 1 && boardState[4] == 1 && boardState[8] == 1) // diagonal 1
			{
				win = true;
			}
			
			if(boardState[6] == 1 && boardState[4] == 1 && boardState[2] == 1) // diagonal 2
			{
				win = true;
			}
			
			else if(boardState[0] == 1 && boardState[3] == 1 && boardState[6] == 1) // vertical 1
			{
				win = true;
			}
			
			if(boardState[1] == 1 && boardState[4] == 1 && boardState[7] == 1) // vertical 2
			{
				win = true;
			}
			
			else if(boardState[2] == 1 && boardState[5] == 1 && boardState[8] == 1) // vertical 3
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

		public boolean allowedMove(int squareNo, Client pl1)
		{
		 if(pl1 == isCurrentPlayer && squareNo == null )  // if conditions are true
			 {
			 Main.isCurrentPlayer == true;
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

import java.net.*;
import java.io.*;
public class Game extends Thread{
protected Socket socket;
Client player1=null;
Client player2=null;
Client currentPlayer=player1;
public Game(Client pl1, Client pl2) 
{
player1=pl1;
player2=pl2;
}
//String inputCMD = input.readLine();
boolean winCheck = false;
boolean tieCheck = false;
String MSG;


public boolean startGame(String inputCMD)
{
	if(inputCMD.startsWith("START"))
	{
		return true;
	}
	return false;
}


//Here we add all of the features of the actual game, once the two clients have connected to each other

void conditionListener(String inputCMD, Client pl1)
{
	if (inputCMD.startsWith("WIN"))
	{
	//won();
	winCheck = true;
	}
	
	else if(inputCMD.startsWith("TIE"))
	{
	//boardFilled();
	tieCheck = true;
	}
}


void moveListener(String inputCMD, int location, Client pl1)
{
	if (inputCMD.startsWith("MOVE"))
	{
		//update move condition
		System.out.println("Player 1 has marked tile: " + location);
	}
}

public String update(Client p1, Client p2, String outputCMD)
{
// take all info, send it to client handler (player 2)
if(winCheck==true)
{
	MSG = p1 + " has won";
	
}
else if(tieCheck==true)
{
	MSG = "is a tie";
}
return MSG;
	}
//BOARD

//Client array for every square of the board, so we can assign each square to a person
private Client[] board = {
		null, null, null, 
		null, null, null, 
		null, null, null};



}


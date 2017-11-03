import java.net.*;
import java.io.*;
public class Game extends Thread{
protected Socket socket;
Client player1=null;
Client player2=null;
Client currentPlayer=player1;
char sign;
public Game(Client pl1, Client pl2, char X, char O) 
{
player1=pl1;
player2=pl2;
sign.pl1='X';
sign.pl2='O';
}

//boolean winCheck = false;
//boolean tieCheck = false;
String CMD;
String outputCMD;

/*
public boolean startGame(String inputCMD)
{
	if(inputCMD.startsWith("START"))
	{
		return true;
	}
	return false;
}
*/

//Here we add all of the features of the actual game, once the two clients have connected to each other

void conditionListener(String inputCMD, Client pl1)
{
	if (inputCMD.startsWith("WIN"))
	{
	//won();
	//winCheck = true;
	CMD = "WIN";
	}
	
	else if(inputCMD.startsWith("TIE"))
	{
	//boardFilled();
	//tieCheck = true;
	CMD = "TIE";
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

public void update(Client pl1)
{
// take all info, send it to client handler (player 2)
while(true)
{
if(player1==pl1)
{
player2.output.outputCMD( CMD );
player2.send();
}
else if(player2==pl1){
player1.output.outputCMD( CMD );
player1.send();
}
}
//BOARD

//Client array for every square of the board, so we can assign each square to a person
private Client[] board = {
		null, null, null, 
		null, null, null, 
		null, null, null};



}


import java.net.*;
import java.io.*;
public class Game extends Thread{
Client player1=null;
Client player2=null;
int gameNo;
public Game(Client pl1, Client pl2, int no) 
{
player1=pl1;
player2=pl2;
gameNo=no;
}
String CMD;
int square;

//Here we add all of the features of the actual game, once the two clients have connected to each other

public void conditionListener(String inputCMD, int location, Client pl)
{
	square=location;
	if (inputCMD.startsWith("WIN"))//if the player sends a message that he has won
	{
	CMD = "LOSE";//send the other player a message that he has lost
	}
	else if(inputCMD.startsWith("TIE"))
	{
	CMD = "TIE";
	}
	else if(inputCMD.startsWith("MOVE")){
	CMD = "OPPONENT_MOVE";
	}
update(pl);
}
public void update(Client pl1)
{
// take all info, send it to client handler (player 2)
if(player1==pl1)
{
player2.output.squareNo=square;
player2.output.packetCMD=CMD;
player2.send();
}
else if(player2==pl1){
player1.output.squareNo=square;
player1.output.packetCMD=CMD;
player1.send();
}
}
}


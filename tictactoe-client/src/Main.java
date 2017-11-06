import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Main{
	static ConnectionHandler handler=new ConnectionHandler();
	static int playerNo;
	static boolean yourTurn;
	static boolean inGame;
	static int firstButtonState=0;
	static int secondButtonState=0;
	static JFrame window = new JFrame("Tic Tac Toe Server-Client project, group 301");
	//LOBBY
	static Label gameOne=new Label();	
	static Label gameTwo=new Label();
	static Label gameOnePlayers=new Label();
	static Label gameTwoPlayers=new Label();
	static JButton lobby[]=new JButton[2];
	//INGAME
    public static ImageIcon X;
    public static ImageIcon O;
    static ImageIcon letter;
    static ImageIcon opponentLetter;
    static int[] board = new int[9];//0 - not taken, 1 - player 1, 2 - player 2
    static JButton button[] = new JButton[9];
    

    public static void main(String[] args) {
 		// Assign images
        	X = new ImageIcon(Main.class.getResource("images/xxx.png"));
			O = new ImageIcon(Main.class.getResource("images/ooo.png"));

    	lobby[0]=new JButton();
    	lobby[1]=new JButton();
    	handler.start();
    	gameOne.setText("Game One");
    	gameTwo.setText("Game Two");
    	gameOnePlayers.setText("0/2");
    	gameTwoPlayers.setText("0/2");
    	lobby[0].setText("Create");
    	lobby[1].setText("Create");
    	window.add(gameOne);
    	window.add(gameOnePlayers);
    	window.add(lobby[0]);
    	window.add(gameTwo);
    	window.add(gameTwoPlayers);
    	window.add(lobby[1]);
    	 lobby[0].addActionListener(new ActionListener(){
        	  public void actionPerformed(ActionEvent a) {
        if(firstButtonState==0){
        	handler.output.lobbyMSG="CREATE_GAME_1";
        	handler.send();
        }
        else if(firstButtonState==1){
        	handler.output.lobbyMSG="JOIN_GAME_1";
        	handler.send();
        }
        else if(firstButtonState==2){
        	handler.output.lobbyMSG="CLOSE_GAME_1";
        	handler.send();
        }
        
        	  }});
    	 lobby[1].addActionListener(new ActionListener(){
       	  public void actionPerformed(ActionEvent a) {
       if(secondButtonState==0){
       	handler.output.lobbyMSG="CREATE_GAME_2";
       	handler.send();
       }
       else if(secondButtonState==1){
       	handler.output.lobbyMSG="JOIN_GAME_2";
       	handler.send();
       }
       else if(secondButtonState==2){
       	handler.output.lobbyMSG="CLOSE_GAME_2";
       	handler.send();
       }
       	  }});
    	 
    	
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	//Lobby
    	window.setSize(500, 500);
    	window.setLayout(new FlowLayout());
    	window.setVisible(true);
    }
public static void ownMove(int sq){
    button[sq].setIcon(letter);
    button[sq].setDisabledIcon(letter);
    button[sq].setEnabled(false);     
}
public static void opponentMove(int sq){
	button[sq].setIcon(opponentLetter);
	button[sq].setDisabledIcon(opponentLetter);
	button[sq].setEnabled(false);
	yourTurn=true;
}
public static void updateLobby(String[] string, int firstState, int secondState){
	gameOne.setText(string[0]);
	gameOnePlayers.setText(string[1]);
	lobby[0].setText(string[2]);
	gameTwo.setText(string[3]);
	gameTwoPlayers.setText(string[4]);
	lobby[1].setText(string[5]);
	firstButtonState=firstState;
	secondButtonState=secondState;
	if(firstButtonState==3){
		lobby[0].setEnabled(false);
	}
	if(secondButtonState==3){
		lobby[1].setEnabled(false);
	}
}
public static void end(String st){
    for (int i = 0; i < 9; i++) {
        button[i] = new JButton();
        window.remove(button[i]);
    }
	Label str=new Label(st);
	window.setLayout(new FlowLayout());
	window.add(str);
	window.repaint();
	window.revalidate();
	window.setVisible(true);
}
public static void startGame(int no){
	System.out.println("started game");
	playerNo=no;
	window.remove(gameOne);
	window.remove(gameOnePlayers);
	window.remove(lobby[0]);
	window.remove(gameTwo);
	window.remove(gameTwoPlayers);
	window.remove(lobby[1]);
	window.setLayout(new GridLayout(3,3));
window.repaint();
window.revalidate();
	  //Game Starts
	   if (playerNo == 1) {
        letter = X;
        opponentLetter=O;
        yourTurn=true;
        
    }

    else if (playerNo == 2) {
        letter = O;
        opponentLetter=X;
    }
 		for ( int i = 0; i < 9; i++) {
 			board[i] = 0;
 		}
 		
         
         
      // Add Buttons
         for (int i = 0; i < 9; i++) {
             button[i] = new JButton();
             window.add(button[i]);
         }
         	
      // Add ActionListener
         for (int i = 0; i < 9; i++) {
             button[i].addActionListener(new ActionListener(){
             	  public void actionPerformed(ActionEvent a) {
             	    	int squareNumber=99;
             	    	for (int i=0;i<button.length;i++){
             	    		if(a.getSource()==button[i]){
             	    			squareNumber=i;
             	    			System.out.println("pressed "+i);
             	    		}
             	    	}
             	    	GameChecker.allowedMove(squareNumber, yourTurn);
             	  }
             });
         }
         window.setVisible(true);
}

}






















































































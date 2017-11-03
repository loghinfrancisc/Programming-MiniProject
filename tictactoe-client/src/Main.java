import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main implements ActionListener { //why the hell are there two mains
	
	public static void main(String[] args) {	


	JFrame window = new JFrame("Tic Tac Toe Server-Client project, group 301");
    JButton button[] = new JButton[9];

    String letterString = "";
    ImageIcon X;
    ImageIcon O;
    ImageIcon letter;
    int val = 0;
    String[] board = new String[9];
    boolean yourTurn = true;
    
    //we are just making two clients here in the main, so the GameChecker recognizes them. 
    //idk where the actual Client objects are created.... 
    
    Client pl1 = new Client(null);
    Client pl2 = new Client(null);
    
    
    public Main() {  //createGame void - what game void ???? - Marius
    		for ( int i = 0; i < 9; i++) {
    			board[i] = "";
    		}
    		
    		// Assign images
            X = new ImageIcon(getClass().getResource("xxx.png"));
            O = new ImageIcon(getClass().getResource("ooo.png"));
            
            window.setSize(1000,1000);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLayout(new GridLayout(3,3));
            
         // Add Buttons
            for (int i = 0; i < 9; i++) {
                button[i] = new JButton();
                window.add(button[i]);
            }
            	
         // Add ActionListener
            for (int i = 0; i < 9; i++) {
                button[i].addActionListener(this);
            }

            window.setVisible(true);
            
    }
    public void actionPerformed(ActionEvent a) {
        // Who's Turn
        if (yourTurn == true) {
            letter = X;
            letterString = "X";
            yourTurn = false;
        }
        else if (yourTurn == false) {
            letter = O;
            letterString = "O";
            yourTurn = true;
        }

        // Display Letters
        for (int i = 0; i < 9; i++) {
            if (a.getSource() == button[i]) {
                button[i].setIcon(letter);
                button[i].setDisabledIcon(letter);
                button[i].setEnabled(false);
                board[i] = letterString;
            }      
        }
      
        //maybe we gonna use it later, dunno
     /*   private boolean wantsToPlayAgain() {
            int response = JOptionPane.showConfirmDialog(frame,
                "Want to play again with my dick?",
                JOptionPane.YES_NO_OPTION);
            frame.dispose();
            return response == JOptionPane.YES_OPTION;
        } */
		}
	}
	//this is code from the Lobby, the Main class had this methods 
	
	//create game
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
	
	//join game
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
	
	//close game
	public static void closeGame(Client player, int no) {// if a user wants to close a game
			if(no == 1 && waitingForGame[0] == player) {// if he wants to close the first game, and is indeed the creator of that
				waitingForGame[0] = null;// remove him from the slot
			}
			else if(no == 2 && waitingForGame[2] == pl) {// same here
				waitingForGame[2] = null;
			}
	}


	
}


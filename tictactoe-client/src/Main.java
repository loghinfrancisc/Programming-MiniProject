import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public static void main(String[] args) {	

public static class Main implements ActionListener {

	JFrame window = new JFrame("Tic Tac Toe Server-Client project, group 301");
    JButton button[] = new JButton[9];

    String letterString = "";
    ImageIcon X;
    ImageIcon O;
    ImageIcon letter;
    int val = 0;
    String[] boardState = new String[9];
    boolean yourTurn = true;
    
    
    public void Main( ) {  //createGame void
    		for ( int i = 0; i < 9; i++) {
    			boardState[i] = "";
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
        //value++;
        // Who's Turn
        if (yourTurn == true) {
            letter = X;
            letterString = "X";
            yourTurn = false;
        }
        if (yourTurn == false) {
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
                boardState[i] = letterString;
            }   
            
        }
      
        //maybe we gonna use it later, dunno
     /*   private boolean wantsToPlayAgain() {
            int response = JOptionPane.showConfirmDialog(frame,
                "Want to play again?",
                JOptionPane.YES_NO_OPTION);
            frame.dispose();
            return response == JOptionPane.YES_OPTION;
        } */
    
		}
    
	}

}

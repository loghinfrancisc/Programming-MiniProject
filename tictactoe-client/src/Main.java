import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener {

	JFrame window = new JFrame("Tic Tac Toe");
    JButton button[] = new JButton[9];

    String letter = "";
    ImageIcon X;
    ImageIcon O;
    ImageIcon ltr;
    int val = 0;
    String[] boardState = new String[9];
    
    
    public void Main( ) {  //createGame void
    		for ( int i = 0; i < 9; i++) {
    			boardState[i] = "";
    		}
    		
    		// Assign images
            X = new ImageIcon(getClass().getResource(""));
            O = new ImageIcon(getClass().getResource(""));
            
            window.setSize(500,500);
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
        value++;
        // Who's Turn
        if (value % 2 == 1) {
            ltr = X;
            letter = "X";
        }
        if (value % 2 == 0) {
            ltr = O;
            letter = "O";
        }

        // Display Letters
        for (int i = 0; i < 9; i++) {
            if (a.getSource() == b[i]) {
                button[i].setIcon(ltr);
                button[i].setDisabledIcon(ltr);
                button[i].setEnabled(false);
                boardState[i] = letter;
            }   
            
        }
        
        private boolean wantsToPlayAgain() {
            int response = JOptionPane.showConfirmDialog(frame,
                "Want to play again?",
                JOptionPane.YES_NO_OPTION);
            frame.dispose();
            return response == JOptionPane.YES_OPTION;
        }
    
	public static void main(String[] args) {	
		new Main();	
	}
	//don't do anything before this
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tictactoe {
	    int boardWidth = 600;
	    int boardHeight = 650; //50 being the textlabel height

	    JFrame frame = new JFrame();
	    JLabel textLabel = new JLabel();
	    JPanel textPanel = new JPanel();
		JPanel boardPanel = new JPanel();

		JButton[] buttons = new JButton[9];


	    Tictactoe() {
	        frame.setVisible(true);
	        frame.setSize(boardWidth, boardHeight);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new BorderLayout());

	        textLabel.setBackground(Color.darkGray);
	        textLabel.setForeground(Color.white);
	        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
	        textLabel.setHorizontalAlignment(JLabel.CENTER);
	        textLabel.setText("Tic-Tac-Toe");
	        textLabel.setOpaque(true);

	        textPanel.setLayout(new BorderLayout());
	        textPanel.add(textLabel);
	        frame.add(textPanel, BorderLayout.NORTH);

			boardPanel.setLayout(new GridLayout(3,3));
			boardPanel.setBackground(Color.GRAY);
			frame.add(boardPanel);

			for (int r = 0; r < buttons.length; r++){
				JButton tile = new JButton();
				buttons[r] = tile;
				buttons[r].setFocusable(false);
				buttons[r].setFont(new Font("Arial", Font.BOLD, 50));
				buttons[r].setBackground(Color.darkGray);
				boardPanel.add(tile);
			}
	    
	    }


}

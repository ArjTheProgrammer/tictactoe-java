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

	JButton[][] buttons = new JButton[3][3];
	String playerX = "X";
	String playerO = "O";
	String currentPlayer = playerX;

	boolean gameOver = false;
	int turns = 0;


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

		for (int r = 0; r < 3; r++){
			for (int c = 0; c < 3; c++){
				JButton tile = new JButton();
				buttons[r][c] = tile;
				boardPanel.add(tile);

				tile.setBackground(Color.darkGray);
				tile.setForeground(Color.white);
				tile.setFont(new Font("Arial", Font.BOLD, 120));
				tile.setFocusable(false);

				tile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						JButton tile = (JButton) e.getSource();
						if (gameOver) return;
						if (tile.getText() == ""){
							tile.setText(currentPlayer);
							turns++;
							checkWinner();
							if (!gameOver){
								currentPlayer = currentPlayer == playerX ? playerO : playerX;
								textLabel.setText(currentPlayer + "'s turn.");
							}
						}
					}
				});
			}
		}
	    
	}
	void checkWinner(){
		//horizontal
		for (int r = 0; r < 3; r++) {
			if(buttons[r][0].getText() == "") continue;

			if (buttons[r][0].getText() == buttons[r][1].getText() &&
				buttons[r][1].getText() == buttons[r][2].getText()) {
				for (int i = 0; i < 3; i++){
					setWinner(buttons[r][i]);
				}
				gameOver = true;
				return;
			}
		}

		//vertical
		for (int c = 0; c < 3; c++) {
			if(buttons[0][c].getText() == "") continue;

			if (buttons[0][c].getText() == buttons[1][c].getText() &&
				buttons[1][c].getText() == buttons[2][c].getText()) {
				for (int i = 0; i < 3; i++){
					setWinner(buttons[i][c]);
				}
				gameOver = true;
				return;
			}
		}

		//diagonal
		if (buttons[0][0].getText() == buttons[1][1].getText() &&
			buttons[1][1].getText() == buttons[2][2].getText() &&
			buttons[0][0].getText() != ""){
				for (int i = 0; i < 3; i++){
					setWinner(buttons[i][i]);
				}
				gameOver = true;
				return;
			}

		//other diagonal
		if (buttons[0][2].getText() == buttons[1][1].getText() &&
			buttons[1][1].getText() == buttons[2][0].getText() &&
			buttons[0][2].getText() != ""){
				setWinner(buttons[0][2]);
				setWinner(buttons[1][1]);
				setWinner(buttons[2][0]);

				gameOver = true;
				return;
			}

		if (turns == 9){
			for (int r = 0; r < 3; r++){
				for (int c = 0; c < 3; c++){
					setTie(buttons[r][c]);
				}
			}
			gameOver = true;
		}
	}

	void setWinner(JButton tile){
		tile.setForeground(Color.green);
		tile.setBackground(Color.lightGray);
		textLabel.setText(currentPlayer + " is the winner");
	}

	void setTie(JButton tile){
		tile.setForeground(Color.orange);
		tile.setBackground(Color.gray);
		textLabel.setText("Tie!");
	}
}

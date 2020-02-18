package FinalProject;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
public class gameFrame {

	private int chances;
	private JFrame frame;
	private JTextField guess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameFrame window = new gameFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public gameFrame() throws MalformedURLException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	private void initialize() throws MalformedURLException, IOException {
		Hangman game = new Hangman();
		
		
		frame = new JFrame();
		
		frame.setBounds(100, 100, 540, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		
		File imageFile = new File("hang.png");
		
		JButton btnEnter = new JButton("Enter");
	
		
		
		guess = new JTextField();
		guess.setText("Test");
		guess.setBounds(202, 302, 116, 22);
		frame.getContentPane().add(guess);
		guess.setColumns(10);
		
		JTextPane enteredLetters = new JTextPane();
		enteredLetters.setToolTipText("Previously entered letters, correct and incorrect");
		enteredLetters.setEditable(false);
		enteredLetters.setBounds(354, 127, 136, 158);
		frame.getContentPane().add(enteredLetters);
		
		JTextPane txtpnEnteredLetters = new JTextPane();
		txtpnEnteredLetters.setText("Entered Letters");
		txtpnEnteredLetters.setBounds(354, 92, 136, 22);
		frame.getContentPane().add(txtpnEnteredLetters);
		
		JTextPane Hanger = new JTextPane();

		Hanger.setEditable(false);
		Hanger.setBounds(41, 92, 116, 140);
		frame.getContentPane().add(Hanger);
		Hanger.setText("\r\n\r\n\r\n\r\n\r\n_|_");

		
		JLabel warningBox = new JLabel("");
		warningBox.setBounds(207, 23, 190, 25);
		frame.getContentPane().add(warningBox);
		
		JTextArea definition = new JTextArea();
		definition.setLineWrap(true);
		definition.setEditable(false);
		definition.setBounds(58, 399, 403, 56);
		frame.getContentPane().add(definition);
		
		JButton btnHint = new JButton("Hint");
		btnHint.setToolTipText("Give up a chance for a hint");
		btnHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnHint.hide();
				definition.setText(game.getDef());
				chances = game.getChances();
				if(chances==7)
				{
					Hanger.setText("\r\n\r\n\r\n\r\n\r\n_|_");}
				if(chances==6)
				{
					Hanger.setText("\r\n-|\r\n-|\r\n-|\r\n-|\r\n_|_");

				}
				if(chances==5)
				{
					Hanger.setText("____________\r\n-|\r\n-|\r\n-|\r\n-|\r\n_|_");
	
				}
				if(chances==4)
				{
					Hanger.setText("____________\r\n-|           |\r\n-|           0\r\n-|\r\n-|\r\n_|_");

				}
				if(chances==3)
				{
					Hanger.setText("____________\r\n-|           |\r\n-|           0\r\n-|           |\r\n-|           |\r\n_|_");

				}
				if(chances==2)
				{
					Hanger.setText("____________\r\n-|           |\r\n-|           0\r\n-|           |\r\n-|           |\r\n_|_        / \\");
	
				}
				if(chances==1)
				{
					Hanger.setText("____________\r\n-|           |\r\n-|           0\r\n-|         \\ | /\r\n-|           |\r\n_|_        / \\");
					btnEnter.hide();
					warningBox.setText("You lose! Try again!");

				}
				if(chances==0)
				{
					btnEnter.hide();
					warningBox.setText("You lose! Try again!");
				}
				
			}
		});
		btnHint.setBounds(364, 301, 97, 25);
		frame.getContentPane().add(btnHint);
		
		JTextArea filler = new JTextArea();
		filler.setBackground(UIManager.getColor("Button.background"));
		filler.setText("");
		filler.setBounds(185, 375, 152, 22);
		frame.getContentPane().add(filler);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					game.Hangman();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				filler.setText(game.getFiller());
				btnHint.show();
				definition.setText("");
				filler.setText(game.getFiller());
				enteredLetters.setText("");
				btnEnter.show();
				
			}
		});
		btnNewGame.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(btnNewGame);
	
		btnEnter.setToolTipText("Press enter when you've made your selection in the area above.");
		btnEnter.setBounds(211, 337, 97, 25);
		frame.getContentPane().add(btnEnter);
		
				btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String actGuess;
				actGuess = guess.getText().substring(0, 1).toLowerCase()+" "+enteredLetters.getText();
				if(enteredLetters.getText().contains(guess.getText().substring(0, 1).toLowerCase()))
				{
					warningBox.setText("Letter already entered! Try again!");
				}
				else {
				enteredLetters.setText(actGuess);
				try {
					game.guess(guess.getText().substring(0,1).toLowerCase());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				guess.setText("");
				int testN = game.getChances();
				Hanger.setText(Integer.toString(testN));
				filler.setText(game.getFiller());
				chances = game.getChances();
				String actWord= game.getWord();
				if(actWord.equals(game.getFiller()))
				{
					warningBox.setText("YOU WIN GREAT JOB!");
					btnEnter.hide();
				}
				if(chances==7)
				{
					Hanger.setText("\r\n\r\n\r\n\r\n\r\n_|_");}
				if(chances==6)
				{
					Hanger.setText("\r\n-|\r\n-|\r\n-|\r\n-|\r\n_|_");

				}
				if(chances==5)
				{
					Hanger.setText("____________\r\n-|\r\n-|\r\n-|\r\n-|\r\n_|_");
	
				}
				if(chances==4)
				{
					Hanger.setText("____________\r\n-|           |\r\n-|           0\r\n-|\r\n-|\r\n_|_");

				}
				if(chances==3)
				{
					Hanger.setText("____________\r\n-|           |\r\n-|           0\r\n-|           |\r\n-|           |\r\n_|_");

				}
				if(chances==2)
				{
					Hanger.setText("____________\r\n-|           |\r\n-|           0\r\n-|           |\r\n-|           |\r\n_|_        / \\");
	
				}
				if(chances==1)
				{
					Hanger.setText("____________\r\n-|           |\r\n-|           0\r\n-|         \\ | /\r\n-|           |\r\n_|_        / \\");
					btnEnter.hide();
					warningBox.setText("You lose! Try again!");

				}
				if(chances==0)
				{
					btnEnter.hide();
					warningBox.setText("You lose! Try again!");
				}
			}
			}
		});
	
	}
}

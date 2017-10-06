import javax.swing.*;
import java.awt.*;
import java.util.*; 
import java.awt.geom.Dimension2D; 

public class MainMenu{

	private LinkedList<JButton> buttons;
	
	public MainMenu(){
		
		setMenuButtons();
		
	}

	public void executeModule(){
		
		init();
		
	}
	
	private JFrame init(){
		
		JFrame frame = new JFrame("Main Menu");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("press X to close");
		label.setPreferredSize(new Dimension(250,50));
		panel.add(label);
		addButtons(panel);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocation(0,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		return frame;
		
	}
	
	private void addButtons(JPanel target){
		
		for(JButton b : this.buttons){
			target.add(b);
		}
		
	}
	
	private void setMenuButtons(){
		
		this.buttons = new LinkedList<JButton>();
		
		JButton gameRules = new JButton("Game Rules");
		JButton newGame = new JButton("New Game!");
		
		//add click handlers
		gameRules.addActionListener(new MainMenuRulesAction());
		newGame.addActionListener(new MainMenuNewGameAction());

		
		this.buttons.add(gameRules);
		this.buttons.add(newGame);

		
	}
	
	

}
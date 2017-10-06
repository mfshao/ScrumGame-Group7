import javax.swing.*;
import java.awt.FlowLayout;
import java.util.*;  

public class GameBoardModule extends Observable implements Observer{

	
	public GameBoardModule(){
		
		//constructor
		
	}

	public void executeModule(){
		
		
		JFrame frame = init();
		//begin!
		
		
		
		//observer example.
		setChanged();
		notifyObservers("Hi. I am game board module. I am sending a message to all of my observers.");
		
	}
	
	private JFrame init(){
		
		JFrame frame = new JFrame("Game Board Module");
        JPanel panel = new JPanel();
		//change layout as needed
        panel.setLayout(new FlowLayout());
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setLocation(600,0);
		//might be messy coding show/hiding these windows(?)
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
		return frame;
		
	}
	
	public void update(Observable o, Object arg) {
		//check for type of o to know what module sent message
		System.out.println("GameBoard received message: " + arg.toString());
	}
	
	
}
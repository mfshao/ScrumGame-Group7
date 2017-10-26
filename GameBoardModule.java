import javax.swing.*;
import java.awt.FlowLayout;
import java.util.*;  

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.GridLayout;
import javax.swing.JSplitPane;

public class GameBoardModule extends Observable implements Observer{

	
	public GameBoardModule(){
		
		//constructor
		
	}

	public void executeModule(){
		
		JFrame frame = init();
		//begin!
		
		//create split pane, player panel and event panel
		JSplitPane splitPane = new JSplitPane();
		JPanel player = new PlayerMan();
		JComponent click = new ClickEvent();
		click.setBounds(0, 0, 600, 800);
		click.setOpaque(true);
		
		// FOR TESTING Panel layouts
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		left.setBackground(Color.BLACK);
		right.setBackground(Color.RED);
		
		// set frame layout
		frame.getContentPane().setLayout(new GridLayout());
		frame.getContentPane().add(splitPane);
		
		//config splitPane
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(200);
		splitPane.setLeftComponent(player);
		splitPane.setRightComponent(click);	

		//observer example.
		setChanged();
		notifyObservers("Hi. I am game board module. I am sending a message to all of my observers.");
		
	}

	private JFrame init(){
		
		JFrame frame = new JFrame("Game Board Module");
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
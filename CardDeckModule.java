import javax.swing.*;
import java.awt.FlowLayout;
import java.util.*;  

public class CardDeckModule extends Observable implements Observer{

	
	public CardDeckModule(){
		
		//constructor
		
	}

	public void executeModule(){
		
		
		JFrame frame = init();
		//begin!
		
		//observer example.
		setChanged();
		notifyObservers("Hi. I am card deck. I am sending a message to all of my observers.");
		
	}
	
	private JFrame init(){
		
		JFrame frame = new JFrame("Card Deck Module");
        JPanel panel = new JPanel();
		//change layout as needed

  		panel.setLayout(new FlowLayout());


        JButton deckOneButton = new JButton("Deck One");
        JButton deckTwoButton = new JButton("Deck Two");
        JButton deckThreeButton = new JButton("Deck Three");


        

        frame.add(panel);
        frame.setSize(600, 300);
        frame.setLocation(0,600);


        panel.add(deckOneButton);
        panel.add(deckTwoButton);
        panel.add(deckThreeButton);
		
        //might be messy coding show/hiding these windows(?)
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
		return frame;
		
	}
	
	public void update(Observable o, Object arg) {
		//check for type of o to know what module sent message
		System.out.println("CardDeck received message: " + arg.toString());
	}


	
}
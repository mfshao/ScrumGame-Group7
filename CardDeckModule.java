import javax.swing.*;
import java.util.*;  
import deck.Deck;
import deckScheme.DeckScheme;
import factory.CardFactory;
import factory.DeckFactory;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import actionListeners.DrawCardActionListener;
import actionListeners.ShuffleDeckActionListener;
import card.Card;


public class CardDeckModule extends Observable implements Observer{

	


	public CardDeckModule(){
		
	}

	public void executeModule(){
		//Card card1 =  Card.generateCard();
		
		JFrame frame = init();
		//begin!
		
		


		//observer example.
		setChanged();
		notifyObservers("Hi. I am card deck. I am sending a message to all of my observers.");
		//setChanged();
		//notifyObservers(card1.getCardTitle());
		
	}
	
	private JFrame init(){
		
DeckFactory deckFactory = new DeckFactory();
		
		ArrayList<Card> cardDesign1 = new ArrayList<Card>() {{
			add(new Card("Big Bug", "-5 Velocity", "Rare"));
			add(new Card("Star Developer Mode", "+5 Velocity", "Rare"));
			add(new Card("Small Bug", "-1 Velocity", "Common"));
			add(new Card("Scope Increase", "-3 Velocity", "Uncommon"));	
			add(new Card("Gettin’ it Done", "+1 Velocity", "Common"));
			add(new Card("Scope Decrease", "+3 Velocity", "Uncommon"));
			
		}};
		
		ArrayList<Card> cardDesign2 = new ArrayList<Card>() {{
			add(new Card("Positive", "+1", "Common"));
			add(new Card("None", "0", "Common"));
			add(new Card("Negative", "-1", "Common"));
			
		}};
		
		ArrayList<Card> cardDesign3 = new ArrayList<Card>() {{
			add(new Card("In The Groove", "Move Up 5 V Points", "Legendary"));
			add(new Card("New Employee", "One Extra Card", "Common"));
			add(new Card("On The Same Page", "+1 EFF per player", "Uncommon"));
			
		}};
		
		DeckScheme deckSchemeScrum = new DeckScheme(cardDesign1, 20);
		DeckScheme deckSchemeEfficiency = new DeckScheme(cardDesign2, 30);
		DeckScheme deckSchemeScrumMaster = new DeckScheme(cardDesign3, 10);
		
		Deck deck1 = new Deck("Scrum", deckSchemeScrum);
		
		Deck deck2 = new Deck("Efficiency", deckSchemeEfficiency);
		
		Deck deck3 = new Deck("Scrum Master", deckSchemeScrumMaster);
		
		Card displayCard = new Card();
		
		JFrame frame = new JFrame("Card Deck Module");
        JPanel panel = new JPanel();
		//change layout as needed

  		panel.setLayout(new GridBagLayout());
  		
  		GridBagConstraints c = new GridBagConstraints();
  		
  		
  		 //DISPLAY CARD
  		//TITLE 4
  		JLabel displayCardName4 = new JLabel("Title",SwingConstants.CENTER);
  		displayCardName4.setOpaque(true);
  		displayCardName4.setHorizontalTextPosition(JLabel.CENTER);
  		displayCardName4.setVerticalTextPosition(JLabel.CENTER);
  		
  		c.gridx = 3;
        c.gridy = 0;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0,5,0,5);
   
        panel.add(displayCardName4,c);
 
        
        //DISPLAY CARD ICON 4
        JLabel displayCardIcon4 = new JLabel("Card Icon", SwingConstants.CENTER);
        displayCardIcon4.setOpaque(true);
        displayCardIcon4.setHorizontalTextPosition(JLabel.CENTER);
        displayCardIcon4.setVerticalTextPosition(JLabel.CENTER);
        
        c.gridx = 3;
        c.gridy = 1;
        
        c.gridheight = 2;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 1;
        c.weighty = 1;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
   
        panel.add(displayCardIcon4,c);
        
        //DISPLAY CARD EFFECT BUTTON 4
        JLabel displayCardeEffect4 = new JLabel("Effect", SwingConstants.CENTER);
        displayCardeEffect4.setOpaque(true);
        displayCardeEffect4.setHorizontalTextPosition(JLabel.CENTER);
        displayCardeEffect4.setVerticalTextPosition(JLabel.CENTER);
        
        c.gridx = 3;
        c.gridy = 3;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
   
        panel.add(displayCardeEffect4,c);
  		
  		//DECK 1
  		//TITLE
  		JLabel deck1Name = new JLabel(deck1.getDeckName(), SwingConstants.CENTER);
        c.gridx = 0;
        c.gridy = 0;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        
        c.insets = new Insets(0,5,0,5);
        
        panel.add(deck1Name,c);
        
        //CARDS LEFT 1
        JLabel deck1CardsLeft = new JLabel(deck1.getDeckSize() + " / " + deck1.getDeckSizeCap(), SwingConstants.CENTER);
  		
        c.gridx = 0;
        c.gridy = 1;
        
        c.gridheight = 1;
        c.gridwidth = 1;
        
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
   
        panel.add(deck1CardsLeft,c);
        
        //DECK ICON 1
        JButton deck1Icon = new JButton("Deck 1 Icon");
  		
        c.gridx = 0;
        c.gridy = 2;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 1;
        c.weighty = 1;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        
        deck1Icon.addActionListener(new DrawCardActionListener(deck1,deck1CardsLeft,displayCardIcon4, displayCardName4,displayCardeEffect4));
        panel.add(deck1Icon,c);
        
        //DECK SHUFFLE BUTTON 1
        JButton deck1Shuffle = new JButton("Shuffle");
  		deck1Shuffle.addActionListener(new ShuffleDeckActionListener(deck1,deck1CardsLeft));
        
  		c.gridx = 0;
        c.gridy = 3;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        
        c.insets = new Insets(5,5,5,5);
        
        panel.add(deck1Shuffle,c);
        
        //DECK 2
  		//TITLE 2
        JLabel deck2Name = new JLabel(deck2.getDeckName(), SwingConstants.CENTER);
  		
        c.gridx = 1;
        c.gridy = 0;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
   
        c.insets = new Insets(0,5,0,5);
        
        panel.add(deck2Name,c);
        
        
        
        //CARDS LEFT 2
        JLabel deck2CardsLeft = new JLabel(deck2.getDeckSize() + " / " + deck2.getDeckSizeCap(), SwingConstants.CENTER);
  		
        c.gridx = 1;
        c.gridy = 1;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
   
        panel.add(deck2CardsLeft,c);
        
        //DECK ICON 2
        JButton deck2Icon = new JButton("Deck 2 Icon");
  		deck2Icon.addActionListener(new DrawCardActionListener(deck2,deck2CardsLeft,displayCardIcon4, displayCardName4,displayCardeEffect4));
        c.gridx = 1;
        c.gridy = 2;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 1;
        c.weighty = 1;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
   
        panel.add(deck2Icon,c);
        
        //DECK SHUFFLE BUTTON 2
        JButton deck2Shuffle = new JButton("Shuffle");
        deck2Shuffle.addActionListener(new ShuffleDeckActionListener(deck2,deck2CardsLeft));
        
        c.gridx = 1;
        c.gridy = 3;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,5);
   
        panel.add(deck2Shuffle,c);
   
        //DECK 3
  		//TITLE 3
        JLabel deck3Name = new JLabel(deck3.getDeckName(), SwingConstants.CENTER);
  		
        c.gridx = 2;
        c.gridy = 0;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0,5,0,5);
   
        panel.add(deck3Name,c);
        
        //CARDS LEFT 3
        JLabel deck3CardsLeft = new JLabel(deck3.getDeckSize() + " / " + deck3.getDeckSizeCap(), SwingConstants.CENTER);
  		
        c.gridx = 2;
        c.gridy = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
   
        panel.add(deck3CardsLeft,c);
        
        //DECK ICON 3
        JButton deck3Icon = new JButton("Deck 3 Icon");
        deck3Icon.addActionListener(new DrawCardActionListener(deck3,deck3CardsLeft,displayCardIcon4, displayCardName4,displayCardeEffect4));
        
        c.gridx = 2;
        c.gridy = 2;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 1;
        c.weighty = 1;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
   
        panel.add(deck3Icon,c);
        
        //DECK SHUFFLE BUTTON 3
        JButton deck3Shuffle = new JButton("Shuffle");
        deck3Shuffle.addActionListener(new ShuffleDeckActionListener(deck3,deck3CardsLeft));
        
        c.gridx = 2;
        c.gridy = 3;
        
        c.gridheight = 1;
        c.gridwidth = 1;
       
        c.ipadx = 0;
        c.ipady = 0;
        
        c.weightx = 0;
        c.weighty = 0;
        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,5);
   
        panel.add(deck3Shuffle,c);
	        
	    
        frame.getContentPane().add(panel);
        frame.setSize(600, 300);
        frame.setLocation(0,600);
        
        //might be messy coding show/hiding these windows(?)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		return frame;
		
	}
	
	public void update(Observable o, Object arg) {
		//check for type of o to know what module sent message
		System.out.println("CardDeck received message: " + arg.toString());
	}




	
}
package actionListeners;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import card.Card;
import deck.Deck;

public class DrawCardActionListener implements ActionListener {
	private Deck deck;
	private JLabel cardsLeft;
	private JLabel displayCardIcon;
	private JLabel displayCardTitle;
	private JLabel displayCardEffect;
	private Card drawnCard;
	
	
	public DrawCardActionListener(Deck deck, JLabel cardsLeft, JLabel displayCardIcon,JLabel displayCardTitle, JLabel displayCardEffect){
		this.deck = deck;
		this.cardsLeft = cardsLeft;
		this.displayCardIcon = displayCardIcon;
		this.displayCardTitle = displayCardTitle;
		this.displayCardEffect = displayCardEffect;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(!deck.deckIsEmpty()){
			drawnCard = deck.drawCard();
			
			cardsLeft.setText(deck.getDeckSize() + " / " + deck.getDeckSizeCap());
			
			displayCardTitle.setText(drawnCard.getTitle());	
			
			
			displayCardTitle.setText(drawnCard.getTitle());
			displayCardIcon.setText(drawnCard.getRarity());
			displayCardEffect.setText(drawnCard.getEffect());
			
			switch (drawnCard.getRarity()) {
				case "Common":
					displayCardIcon.setBackground(Color.GRAY);
					break;
				case "Uncommon":
					displayCardIcon.setBackground(Color.GREEN);
					break;
				case "Rare":
					displayCardIcon.setBackground(Color.BLUE);
					break;
				case "Epic":
					displayCardIcon.setBackground(Color.MAGENTA);
					break;
				case "Legendary":
					displayCardIcon.setBackground(Color.ORANGE);
					break;
				default:
					displayCardIcon.setBackground(Color.BLACK);
					break;
			}
		}
	}

}

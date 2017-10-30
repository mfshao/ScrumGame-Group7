package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import deck.Deck;

public class ShuffleDeckActionListener implements ActionListener {
	private Deck deck;
	private JLabel cardsLeft;
	
	public ShuffleDeckActionListener(Deck deck, JLabel cardsLeft){
		this.deck = deck;
		this.cardsLeft = cardsLeft;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		deck.shuffle();
		cardsLeft.setText(deck.getDeckSize() + " / " + deck.getDeckSizeCap());

	}

}

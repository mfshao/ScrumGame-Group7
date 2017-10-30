package deck;

import java.util.Queue;

import bag.Bag;
import card.Card;

public interface IDeck {
	Card drawCard();
	
	void discardCard(Card card);	
	void addCard(Card card);
	void shuffle();
	
	boolean deckIsEmpty();
	boolean contains(Card checkCard);
	
	void showDeck();
	void showDiscard();
	
	String getDeckName();
	int getDeckSize();
	int getDeckSizeCap();
	Queue<Card> getCards();
	Bag getDiscard();
	
	
}

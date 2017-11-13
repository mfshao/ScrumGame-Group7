package deck;

import java.util.LinkedList;
import java.util.Queue;

import bag.Bag;
import card.Card;
import deckScheme.DeckScheme;
import factory.DeckFactory;

public class Deck implements IDeck {
	private Queue<Card> deck;
	private Bag discard;
	private int deckSizeCap;
	private String deckName;
	
	public Deck() {
		this.deckName = "default deck";
		this.deck = new LinkedList<Card>();
		this.discard = new Bag();
		this.deckSizeCap = deck.size();
	}
	
	public Deck(String deckName, DeckScheme deckScheme) {
		DeckFactory deckfactory = new DeckFactory();
		
		this.deck = deckfactory.createDeck(deckScheme);
		this.discard = new Bag();
		this.deckName = deckName;
		this.deckSizeCap = deck.size();
	}
	
	@Override
	public void discardCard(Card card) {
		discard.drop(card);
	}
	
	@Override
	public Card drawCard() {
		if (!deck.isEmpty()) {
			Card card = (Card) deck.remove();
			discardCard(card);
			return card;
		}
		return null;
	}

	
	@Override
	public void addCard(Card card) {
		deck.add(card);
	}

	@Override
	public void shuffle() {
		while (!deck.isEmpty()) {
			discard.drop(deck.remove());
		}
		
		
		while (!discard.isEmpty()) {
			deck.add(discard.take());
		}
	}

	@Override
	public boolean deckIsEmpty() {
		return deck.isEmpty();
	}

	@Override
	public void showDeck() {
		System.out.println(deckName + " Deck:\n[");
		for (Card card : deck) {
			System.out.println("\t" + card.toString());
		}
		System.out.println("]");
	}


	@Override
	public void showDiscard() {
		
		System.out.println(deckName + " Discard:\n[");
		System.out.println(discard.toString());
		System.out.println("]");
		System.out.println();
	}

	@Override
	public String toString() {
		String toStringMessage = deckName +  " Deck:" + "\n[";
		
		
		for (Card card : deck) {
			toStringMessage += "\t" + card.toString() + "\n";
		}
		toStringMessage += "]";
		
		return toStringMessage;
	}
	
	@Override
	public String getDeckName() {
		return deckName;
	}

	@Override
	public int getDeckSizeCap() {
		return deckSizeCap;
	}

	@Override
	public int getDeckSize() {
		return deck.size();
	}
	@Override
	public Queue<Card> getCards() {
		return deck;
	}

	@Override
	public Bag getDiscard() {
		return discard;
	}

	@Override
	public boolean contains(Card checkCard) {
		for (Card card: deck) {
			if (card.getTitle().equals(checkCard.getTitle())) {
				return true;
			}
		}
		
		if (discard.contains(checkCard)) {
			return true;
		}
		
		return false;
	}

	

}

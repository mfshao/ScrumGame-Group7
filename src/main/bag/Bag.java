package bag;

import java.util.ArrayList;
import java.util.Iterator;

import card.Card;


public class Bag {
	private int size;
	private ArrayList<Card> bag;
	
	
	public Bag() {
		size = 0;
		bag = new ArrayList<Card>();
	}
	
	public void drop(Card card) {
		bag.add(card);
		size++;
	}
	
	public Card take() {
		int randomIndex = (int)(Math.random() * (size-1));
		Card removedCard = bag.remove(randomIndex);
		size--;
		return removedCard;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size > 0) {
			return false;
		}
		return true;
	}
	
	
	public boolean contains(Card checkCard) {
		for  (Card card: bag) {
			if (card.getTitle().equals(checkCard.getTitle())) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		
		String message = "";
		
		for (Card card : bag) {
			message += "\t" + card.toString() + "\n";
		}
		return message;
	}
	
	public ArrayList<Card> getContent() {
		return bag;
	}

}

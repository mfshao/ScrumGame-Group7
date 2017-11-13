package deck;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import bag.Bag;
import card.Card;
import deckScheme.DeckScheme;

public class DeckTest {

	@Test
	public void testDefaultDeck() {
		try {
			Deck deck = new Deck();
			
			Queue <Card> deckCards = deck.getCards();
			Bag deckDiscard = deck.getDiscard();
			
			boolean testFailChecker = false;
			
			if (!deck.getDeckName().equals("default deck") || deck.getDeckSize() != 0) {
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testDeckWithNameDeckScheme() {
		try {
		
			ArrayList<Card> cards = new ArrayList<Card>() {{
				add(new Card("Big Bug", "-5 Velocity", "Rare"));
				add(new Card("Rock Star Developer Mode", "+5 Velocity", "Rare"));
				add(new Card("Small Bug", "-1 Velocity", "Common"));
				add(new Card("Scope Increase", "-1 Velocity", "Common"));	
				add(new Card("Gettin’ it Done", "+1 Velocity", "Common"));
				add(new Card("Scope Decrease", "+1 Velocity", "Common"));
				
			}};
			
			int deckSize = 6;
			
			DeckScheme deckScheme = new DeckScheme(cards,deckSize);
			
			String deckName = "Test Deck";
			
			
			Deck deck = new Deck(deckName,deckScheme);
			
			Queue <Card> deckCards = deck.getCards();
			Bag deckDiscard = deck.getDiscard();
			
			boolean testFailChecker = false;
			
			if (!deck.getDeckName().equals(deckName) || deck.getDeckSize() != deckSize 
					|| !deck.contains(cards.get(0)) || !deck.contains(cards.get(2))|| !deck.contains(cards.get(3))
					|| !deck.contains(cards.get(4))|| !deck.contains(cards.get(5))) {
				
				
				
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testDiscardCard() {
		try {
			Deck deck = new Deck();
			
			Card testCard  = new Card("Big Bug", "-5 Velocity", "Rare");
			
			deck.addCard(testCard);
			
			deck.drawCard();
			
			Bag deckDiscard = deck.getDiscard();
			
			boolean testFailChecker = false;
			
			if (!deckDiscard.contains(testCard)) {
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testDrawCard() {
		try {
			Deck deck = new Deck();
			
			Card testCard  = new Card("Big Bug", "-5 Velocity", "Rare");
			
			deck.addCard(testCard);
			
			Card drewCard  = deck.drawCard();
			
			
			boolean testFailChecker = false;
			
			if (!(testCard == drewCard)) {
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testAddCard() {
		try {
			Deck deck = new Deck();
			
			Card testCard  = new Card("Big Bug", "-5 Velocity", "Rare");
			
			deck.addCard(testCard);
			
			
			boolean testFailChecker = false;
			
			if (!deck.contains(testCard)) {
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testShuffle() {
		try {
			Deck deck = new Deck();
			
			deck.addCard(new Card(1,"test title", "test effect", "Common"));
			deck.addCard(new Card(2,"test title", "test effect", "Common"));
			deck.addCard(new Card(3,"test title", "test effect", "Common"));
			deck.addCard(new Card(4,"test title", "test effect", "Common"));
			deck.addCard(new Card(5,"test title", "test effect", "Common"));
			deck.addCard(new Card(6,"test title", "test effect", "Common"));
			deck.addCard(new Card(7,"test title", "test effect", "Common"));
			deck.addCard(new Card(8,"test title", "test effect", "Common"));
			deck.addCard(new Card(9,"test title", "test effect", "Common"));
			deck.addCard(new Card(10,"test title", "test effect", "Common"));
			
			int[] deckCardNumberList = {1,2,3,4,5,6,7,8,9,10};
			
			deck.shuffle();
			
			
			int cardNumChecker = 0;
			
			
			Queue <Card> deckCards = deck.getCards();
			int deckCardsSize = deckCards.size();
			
			for (int i = 0; i < deckCardsSize; i++) {
				if (deckCards.remove().getNumber() == deckCardNumberList[i]) {
					cardNumChecker ++;
				}
			}
			
			
		
			boolean testFailChecker = false;
			
			if (cardNumChecker == 10) {
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testDeckIsEmpty() {
		try {
			Deck deck = new Deck();
			
			
			Queue <Card> deckCards = deck.getCards();
			
			boolean testFailChecker = false;
			
			if (!deckCards.isEmpty()) {
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testShowDeck() {
		assertTrue(true);
	}

	@Test
	public void testShowDiscard() {
		assertTrue(true);
	}

	@Test
	public void testToString() {
		try {
			
			ArrayList<Card> cards = new ArrayList<Card>() {{
				add(new Card("Big Bug", "-5 Velocity", "Rare"));
				add(new Card("Rock Star Developer Mode", "+5 Velocity", "Rare"));
				add(new Card("Small Bug", "-1 Velocity", "Common"));
				add(new Card("Scope Increase", "-1 Velocity", "Common"));	
				add(new Card("Gettin’ it Done", "+1 Velocity", "Common"));
				add(new Card("Scope Decrease", "+1 Velocity", "Common"));
				
			}};
			
			int deckSize = 6;
			
			DeckScheme deckScheme = new DeckScheme(cards,deckSize);
			
			String deckName = "Test Deck";
			
			
			Deck deck = new Deck(deckName,deckScheme);
			
			Queue <Card> deckCards = deck.getCards();
			
			
			String toStringMessageCheck = deckName +  " Deck:" + "\n[";
			
			int deckCardsSize = deckCards.size();
			
			String toStringMessage = deck.toString();
			
			Card card;
			for (int i = 0; i < deckCardsSize; i++) {
				card = deckCards.remove();
				toStringMessageCheck += "\t" + card.toString() + "\n";
			}
			
			toStringMessageCheck += "]";
			
			
			boolean testFailChecker = false;
			
			if (!toStringMessageCheck.equals(toStringMessage)) {
				
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testGetDeckName() {
		try {
			
			ArrayList<Card> cards = new ArrayList<Card>() {{
				add(new Card("Big Bug", "-5 Velocity", "Rare"));
				add(new Card("Rock Star Developer Mode", "+5 Velocity", "Rare"));
				add(new Card("Small Bug", "-1 Velocity", "Common"));
				add(new Card("Scope Increase", "-1 Velocity", "Common"));	
				add(new Card("Gettin’ it Done", "+1 Velocity", "Common"));
				add(new Card("Scope Decrease", "+1 Velocity", "Common"));
				
			}};
			
			int deckSize = 6;
			
			DeckScheme deckScheme = new DeckScheme(cards,deckSize);
			
			String deckName = "Test Deck";
			
			
			Deck deck = new Deck(deckName,deckScheme);
			
			
			
			boolean testFailChecker = false;
			
			if (!deckName.equals(deck.getDeckName())) {
							
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testGetDeckSize() {
		try {
			
			ArrayList<Card> cards = new ArrayList<Card>() {{
				add(new Card("Big Bug", "-5 Velocity", "Rare"));
				add(new Card("Rock Star Developer Mode", "+5 Velocity", "Rare"));
				add(new Card("Small Bug", "-1 Velocity", "Common"));
				add(new Card("Scope Increase", "-1 Velocity", "Common"));	
				add(new Card("Gettin’ it Done", "+1 Velocity", "Common"));
				add(new Card("Scope Decrease", "+1 Velocity", "Common"));
				
			}};
			
			int deckSize = 6;
			
			DeckScheme deckScheme = new DeckScheme(cards,deckSize);
			
			String deckName = "Test Deck";
			
			
			Deck deck = new Deck(deckName,deckScheme);
			
			
			
			boolean testFailChecker = false;
			
			if (deck.getDeckSize() != deckSize) {
							
				testFailChecker = true;
			}
			
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

	@Test
	public void testGetCards() {
		try {
			
			ArrayList<Card> cards = new ArrayList<Card>() {{
				add(new Card("Big Bug", "-5 Velocity", "Rare"));
				add(new Card("Rock Star Developer Mode", "+5 Velocity", "Rare"));
				add(new Card("Small Bug", "-1 Velocity", "Common"));
				add(new Card("Scope Increase", "-1 Velocity", "Common"));	
				add(new Card("Gettin’ it Done", "+1 Velocity", "Common"));
				add(new Card("Scope Decrease", "+1 Velocity", "Common"));
				
			}};
			
			int deckSize = 6;
			
			DeckScheme deckScheme = new DeckScheme(cards,deckSize);
			
			String deckName = "Test Deck";
			
			
			Deck deck = new Deck(deckName,deckScheme);
			
			Queue <Card> deckCards = new LinkedList<Card>(deck.getCards());
			
			
			int deckCardsSize = deckCards.size();
			
			
			Card deckCard;
			Card deckCardCheck;
			
			boolean testFailChecker = false;
			
			for (int i = 0; i < deckCardsSize; i++) {
				deckCard = deck.drawCard();
				deckCardCheck = deckCards.remove();
				
				if (deckCard.getNumber() != deckCardCheck.getNumber()) {
					testFailChecker = true;
				}
			}
			
			assertFalse(testFailChecker);
		}
		
		catch(NullPointerException ex) {
			fail(ex.getClass() +  " not created");
		}
	}

}

package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import card.Card;
import deck.Deck;
import deckScheme.DeckScheme;

public class DeckFactory {
	public Queue<Card> createDeck(DeckScheme deckScheme) {
		if (deckScheme == null) {
			return null;
		}
		
		CardFactory cardFactory = new CardFactory();
		Deck deck =  new Deck();
		
		int cardNumber = 1;
		int moduloChecker;
		
		ArrayList<Card> commonCards = deckScheme.getCommonCards();
		ArrayList<Card> uncommonCards = deckScheme.getUncommonCards();
		ArrayList<Card> rareCards = deckScheme.getRareCards();
		ArrayList<Card> epicCards = deckScheme.getEpicCards();
		ArrayList<Card>	legendaryCards = deckScheme.getLegendaryCards();
		
		List<Integer> cardsPerChance = deckScheme.getNumberOfCards();
		
		if (!commonCards.isEmpty()) {
			moduloChecker = commonCards.size();
			for (int i = cardsPerChance.get(0); i > 0; i-- ) {
				deck.addCard(cardFactory.createCard(cardNumber, commonCards.get(cardNumber % moduloChecker)));
				cardNumber++;
			}
		}
		
		if (!uncommonCards.isEmpty()) {
			moduloChecker = uncommonCards.size();
			for (int i = cardsPerChance.get(1); i > 0; i-- ) {
				deck.addCard(cardFactory.createCard(cardNumber, uncommonCards.get(cardNumber % moduloChecker)));
				cardNumber++;
			}
		}
		
		if (!rareCards.isEmpty()) {
			moduloChecker = rareCards.size();
			for (int i = cardsPerChance.get(2); i > 0; i-- ) {
				deck.addCard(cardFactory.createCard(cardNumber, rareCards.get(cardNumber % moduloChecker)));
				cardNumber++;
			}
		}
		
		if (!epicCards.isEmpty()) {
			moduloChecker = epicCards.size();
			for (int i = cardsPerChance.get(3); i > 0; i-- ) {
				deck.addCard(cardFactory.createCard(cardNumber, epicCards.get(cardNumber % moduloChecker)));
				cardNumber++;
			}
		}
		
		if (!legendaryCards.isEmpty()) {
			moduloChecker = legendaryCards.size();
			for (int i = cardsPerChance.get(4); i > 0; i-- ) {
				deck.addCard(cardFactory.createCard(cardNumber, legendaryCards.get(cardNumber % moduloChecker)));
				cardNumber++;
			}
		}
		
		deck.shuffle();
		
		return deck.getCards();
		
	}
}


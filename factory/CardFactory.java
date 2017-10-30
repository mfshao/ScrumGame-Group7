package factory;

import card.Card;

public class CardFactory {

	public Card createCard(int cardNumber, String cardTitle, String cardEffect, String cardRarity) {
		
		if (cardNumber < 0 || cardTitle == null || cardEffect == null || cardRarity == null) {
			return null;
		}
		
		return new Card(cardNumber, cardTitle, cardEffect, cardRarity);
		
	}
	
	public Card createCard(int cardNumber, Card partialCard) {
			
			if (cardNumber < 0 || partialCard == null) {
				return null;
			}
			
			return new Card(cardNumber, partialCard.getTitle(), partialCard.getEffect(), partialCard.getRarity());
			
		}
}

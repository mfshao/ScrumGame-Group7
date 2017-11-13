package card;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {
	
	@Test
	public void testCardDefaultCreation() {
		Card card = new Card();
		
		String defaultCardTitle = "default title";
		String defaultCardEffect = "default effect";
		String defaultCardRarity = "default rarity";
		int defaultCardNumber = 0;
		
		boolean defaultCardCreationCheck = false;
		
		if (card.getEffect().equals(defaultCardEffect) && card.getTitle().equals(defaultCardTitle) 
				&& card.getRarity().equals(defaultCardRarity) && card.getNumber() == defaultCardNumber) {
			
			defaultCardCreationCheck = true;
		}
		
		assertTrue(defaultCardCreationCheck);
	}

	@Test
	public void testCardCreationWithNameEffectRarity() {
		String cardTitle = "test card name";
		String cardEffect = "test card effect";
		String cardCardRarity = "test card rarity";
		
		Card card = new Card(cardTitle,cardEffect,cardCardRarity);
		
		
		boolean CardCreationCheck = false;
		
		if (card.getEffect().equals(cardEffect) && card.getTitle().equals(cardTitle) 
				&& card.getRarity().equals(cardCardRarity)) {
			
			CardCreationCheck = true;
		}
		
		assertTrue(CardCreationCheck);
	}
	

	@Test
	public void testCardCreationWithNumberNameEffectRarity() {
		String cardTitle = "test card name";
		String cardEffect = "test card effect";
		String cardCardRarity = "test card rarity";
		int cardNumber = 1;
		
		Card card = new Card(cardNumber,cardTitle,cardEffect,cardCardRarity);
		
		
		boolean CardCreationCheck = false;
		
		if (card.getEffect().equals(cardEffect) && card.getTitle().equals(cardTitle) 
				&& card.getRarity().equals(cardCardRarity) && card.getNumber() == cardNumber) {
			
			CardCreationCheck = true;
		}
		
		assertTrue(CardCreationCheck);
	}

	@Test
	public void testCardGetTitle() {
		String cardTitle = "test card name";
		String cardEffect = "test card effect";
		String cardCardRarity = "test card rarity";
		int cardNumber = 1;
		
		Card card = new Card(cardNumber,cardTitle,cardEffect,cardCardRarity);
		
		assertEquals(cardTitle,card.getTitle());
	}

	@Test
	public void testCardGetEffect() {
		String cardTitle = "test card name";
		String cardEffect = "test card effect";
		String cardCardRarity = "test card rarity";
		int cardNumber = 1;
		
		Card card = new Card(cardNumber,cardTitle,cardEffect,cardCardRarity);
		
		assertEquals(cardEffect,card.getEffect());
	}

	@Test
	public void testCardGetNumber() {
		String cardTitle = "test card name";
		String cardEffect = "test card effect";
		String cardCardRarity = "test card rarity";
		int cardNumber = 1;
		
		Card card = new Card(cardNumber,cardTitle,cardEffect,cardCardRarity);
		
		assertEquals(cardNumber,card.getNumber());
	}

	@Test
	public void testCardGetRarity() {
		String cardTitle = "test card name";
		String cardEffect = "test card effect";
		String cardCardRarity = "test card rarity";
		int cardNumber = 1;
		
		Card card = new Card(cardNumber,cardTitle,cardEffect,cardCardRarity);
		
		assertEquals(cardCardRarity,card.getRarity());
	}

	@Test
	public void testCardToString() {
		String cardTitle = "test card name";
		String cardEffect = "test card effect";
		String cardCardRarity = "test card rarity";
		int cardNumber = 1;
		
		Card card = new Card(cardNumber,cardTitle,cardEffect,cardCardRarity);
		
		
		String cardToStringTester = "{#"+ card.getNumber() + "|" + card.getTitle() + "|" + card.getEffect() + "|"+ card.getRarity() +"}";
		
		
		assertEquals(cardToStringTester,card.toString());
	}

}

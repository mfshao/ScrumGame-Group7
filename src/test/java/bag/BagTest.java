package bag;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import card.Card;

public class BagTest {

	@Test
	public void testBagDefault() {
		
		try {
		Bag testBag = new Bag();
		
		int size = 0;
		ArrayList<Card> testArray;
		
		assertEquals (testBag.getSize(), size);
		
		}
		catch (NullPointerException ex) {
			fail(ex.getClass() + " was not created.");
		}
	}

	@Test
	public void testDrop() {
		Bag testBag = new Bag();
		
		Card testCard  = new Card();
		
		testBag.drop(testCard);
		
		ArrayList<Card> testArray = new ArrayList<Card>(testBag.getContent());
		
		assertTrue(testArray.contains(testCard));
	}

	@Test
	public void testTake() {
		Bag testBag = new Bag();
		
		Card testCard1  = new Card();
		Card testCard2  = new Card();
		Card testCard3  = new Card();
		
		int bagSize = testBag.getSize();
		
		testBag.drop(testCard1);
		testBag.drop(testCard2);
		testBag.drop(testCard3);
		
		Card takenCard =  testBag.take();
		
		int expectedSize = 2;
		
		boolean failCheck = false;
		
		if ((takenCard.equals(testCard1) ||takenCard.equals(testCard2) ||takenCard.equals(testCard3)) && (bagSize == expectedSize)) {
			failCheck = true;
		}
		
		assertFalse(failCheck);
	}

	@Test
	public void testGetSize() {
		Bag testBag = new Bag();
		
		Card testCard1  = new Card();
		Card testCard2  = new Card();
		Card testCard3  = new Card();
		
		testBag.drop(testCard1);
		testBag.drop(testCard2);
		testBag.drop(testCard3);
		
		int bagSize = testBag.getSize();
		
		int expectedBagSize = 3 ;
		
		assertEquals(bagSize, expectedBagSize );
	}

	@Test
	public void testIsEmpty() {
		Bag testBag = new Bag();
		
		
		ArrayList<Card> testArray = testBag.getContent();
		
		assertEquals(testArray.isEmpty(),testBag.isEmpty());
	}

	@Test
	public void testContains() {
		Bag testBag = new Bag();
		
		Card testCard  = new Card();
		
		testBag.drop(testCard);
		
		assertTrue(testBag.contains(testCard));
	}

	@Test
	public void testToString() {
		Bag testBag = new Bag();
		
		Card testCard1  = new Card();
		
		testBag.drop(testCard1);

		
		String message = "";
		
		message += "\t" + testCard1.toString() + "\n";

		assertEquals(message,testBag.toString());
	}

}

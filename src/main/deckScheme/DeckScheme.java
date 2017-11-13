package deckScheme;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public class DeckScheme implements IDeckScheme {
	private int deckSize;
	
	private double commonChance = 36;
	private double uncommonChance = 28;
	private double rareChance = 20;
	private double epicChance = 12;
	private double legendaryChance = 4;
	
	private List<Integer> numberPerChance = new ArrayList<Integer>(5);
	
	private double leftOverChance = 0;
	
	private ArrayList<Integer> chancesNotAvailable = new ArrayList<Integer>();
	
	private ArrayList<Card> commonCards = new ArrayList<Card>();
	private ArrayList<Card> uncommonCards = new ArrayList<Card>();
	private ArrayList<Card> rareCards = new ArrayList<Card>();
	private ArrayList<Card> epicCards = new ArrayList<Card>();
	private ArrayList<Card> legendaryCards = new ArrayList<Card>();
	
	
	
	public DeckScheme() {
		
	}
	
	public DeckScheme(ArrayList<Card> cards, int size) {
			deckSize = size;
			splitSchemeCards(cards);
			checkLeftOverChance();
			splitLeftOverChance();
			getNumberPerChance();
	}
	
	private void splitSchemeCards(ArrayList<Card> cards) {	
		for (Card card : cards) {
			switch (card.getRarity()) {
				case ("Common"):
					commonCards.add(card);
					break;
				case ("Uncommon"):
					uncommonCards.add(card);
					break;
				case ("Rare"):
					rareCards.add(card);
					break;
				case ("Epic"):
					epicCards.add(card);
					break;
				case ("Legendary"):
					legendaryCards.add(card);
					break;
				default:
					commonCards.add(card);
					break;
			}
		}
	}
	
	private void checkLeftOverChance() {
		if (commonCards.isEmpty()) {
			leftOverChance += commonChance;
			commonChance = 0;
			chancesNotAvailable.add(1);
		}
		if (uncommonCards.isEmpty()) {
			leftOverChance += uncommonChance;
			uncommonChance = 0;
			chancesNotAvailable.add(2);
		}
		if (rareCards.isEmpty()) {
			leftOverChance += rareChance;
			rareChance = 0;
			chancesNotAvailable.add(3);
		}
		if (epicCards.isEmpty()) {
			leftOverChance += epicChance;
			epicChance = 0;
			chancesNotAvailable.add(4);
		}
		if (legendaryCards.isEmpty()) {
			leftOverChance += legendaryChance;
			legendaryChance = 0;
			chancesNotAvailable.add(5);
		}
	}
	
	
	private void splitLeftOverChance() {
		double extraChance = leftOverChance / (double) (5 - chancesNotAvailable.size());
		
		if (!chancesNotAvailable.contains(1)) {
			commonChance += extraChance;
		}
		
		if (!chancesNotAvailable.contains(2)) {
			uncommonChance += extraChance;
		}
		
		if (!chancesNotAvailable.contains(3)) {
			rareChance += extraChance;
		}
		
		if (!chancesNotAvailable.contains(4)) {
			epicChance += extraChance;
		}
		if (!chancesNotAvailable.contains(5)) {
			legendaryChance += extraChance;
		}
	}
	
	public void bluePrint() {
		System.out.println("Deck Size: " + deckSize);
		
		System.out.println("Cards:");
		
		if (!commonCards.isEmpty()) {
			System.out.println("\t Common: " + numberPerChance.get(0) + " cards");
			for (Card card : commonCards) {
				System.out.println("\t\t" + card.toString());
			}
		}
		
		if (!uncommonCards.isEmpty()) {
			System.out.println("\t Uncommon: " + numberPerChance.get(1) + " cards");
			for (Card card : uncommonCards) {
				System.out.println("\t\t" + card.toString());
			}
		}
		
		if (!rareCards.isEmpty()) {
			System.out.println("\t Rare: " + numberPerChance.get(2) + " cards");
			for (Card card : rareCards) {
				System.out.println("\t\t" + card.toString());
			}
		}
		if (!epicCards.isEmpty()) {
			System.out.println("\t Epic: "  + numberPerChance.get(3) + " cards");
			for (Card card : epicCards) {
				System.out.println("\t\t" + card.toString());
			}
		}
		if (!legendaryCards.isEmpty()) {
			System.out.println("\t Legendary: "  + numberPerChance.get(4) + " cards");
			for (Card card : legendaryCards) {
				System.out.println("\t\t" + card.toString());
			}
		}
		
		System.out.println("Chances:");
		System.out.println("\t Common:" + commonChance);
		System.out.println("\t Uncommon:" + uncommonChance);
		System.out.println("\t Rare: " + rareChance);
		System.out.println("\t Epic: " + epicChance);
		System.out.println("\t Legendary: " + legendaryChance);
	}
	
	private void getNumberPerChance() {
		int deckSizeCheck = 0;
		
		numberPerChance.add((int) ((commonChance / 100.00) * deckSize));
		numberPerChance.add((int) ((uncommonChance / 100.00) * deckSize));
		numberPerChance.add((int) ((rareChance / 100.00) * deckSize));
		numberPerChance.add((int) ((epicChance / 100.00) * deckSize));
		numberPerChance.add((int) ((legendaryChance / 100.00) * deckSize));
		
		for(int number : numberPerChance) {
			deckSizeCheck += number;
		}
		
		numberPerChance.set(0, numberPerChance.get(0) + (deckSize - deckSizeCheck));
	}
	
	public ArrayList<Card> getCommonCards(){
		return commonCards;
	}
	
	public ArrayList<Card> getUncommonCards(){
		return uncommonCards;
	}
	public ArrayList<Card> getRareCards(){
		return rareCards;
	}
	public ArrayList<Card> getEpicCards(){
		return epicCards;
	}
	public ArrayList<Card> getLegendaryCards(){
		return legendaryCards;
	}
	public List<Integer> getNumberOfCards(){
		return  numberPerChance;
	}
}

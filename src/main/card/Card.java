package card;

public class Card implements ICard {
	private String title;
	private String effect;
	private int number;
	private String rarity;
	
	public Card () {
		this.title = "default title";
		this.effect = "default effect";
		this.number = 0;
		this.rarity = "default rarity";
	}
	
	public Card (String title, String effect, String rarity) {
		number = 0;
		this.title = title;
		this.effect = effect;
		this.rarity = rarity;
	}
	
	public Card (int number, String title, String effect, String rarity) {
		this.number = number;
		this.title = title;
		this.effect = effect;
		this.rarity = rarity;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getEffect() {
		return effect;
	}
	
	
	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public String getRarity() {
		return rarity;
	}
	
	@Override
	public String toString() {
		return "{#"+ number + "|" + title + "|" + effect + "|"+ rarity +"}";
	}

}

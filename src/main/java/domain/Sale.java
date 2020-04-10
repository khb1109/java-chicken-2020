package domain;

public class Sale {
	private final long money;

	public Sale(long money) {
		this.money = money;
	}

	public Sale calculateChickenSale(int chickenCount) {
		return new Sale(money - chickenCount * 10000);
	}
}

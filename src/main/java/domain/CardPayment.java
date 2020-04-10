package domain;

public class CardPayment extends Payment {
	public CardPayment(Table table) {
		super(table);
	}

	@Override
	public Money calculate() {
		return money;
	}
}

package domain;

public class CardPayment extends Payment {
	public CardPayment(Table table) {
		super(table);
	}

	@Override
	public long calculate() {
		return 0;
	}
}

package domain;

public class CachePayment extends Payment {
	public CachePayment(Table table) {
		super(table);
	}

	@Override
	public Money calculate() {
		return money;
	}
}

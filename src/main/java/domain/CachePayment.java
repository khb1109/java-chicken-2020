package domain;

public class CachePayment extends Payment {
	public CachePayment(Table table) {
		super(table);
	}

	@Override
	public long calculate() {
		return 0;
	}
}

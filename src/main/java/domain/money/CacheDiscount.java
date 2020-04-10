package domain.money;

public class CacheDiscount extends Discount {
	private static final double RATE_OF_DISCOUNT = 5;

	@Override
	protected Money calculateDiscount(Money originMoney) {
		return originMoney.multiply(RATE_OF_DISCOUNT * 0.01);
	}
}

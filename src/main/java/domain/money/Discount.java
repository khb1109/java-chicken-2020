package domain.money;

public abstract class Discount {
	public Money discount(Money originMoney) {
		Money reducedPrice = calculateDiscount(originMoney);
		return originMoney.minus(reducedPrice);
	}

	protected abstract Money calculateDiscount(Money originMoney);
}

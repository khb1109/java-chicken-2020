package domain;

public class ChickenDiscount extends Discount {

	private final int chickAmount;

	public ChickenDiscount(int chickenAmount) {
		validate(chickenAmount);
		this.chickAmount = chickenAmount;
	}

	private void validate(int chickenAmount) {
		if (chickenAmount < 0) {
			throw new IllegalArgumentException("잘못된 수량 입니다.");
		}
	}

	@Override
	protected Money calculateDiscount(Money originMoney) {
		return new Money((chickAmount / 10) * 10000);
	}
}

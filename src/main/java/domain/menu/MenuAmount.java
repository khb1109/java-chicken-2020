package domain.menu;

import java.util.Objects;

public class MenuAmount {
	private final long amount;

	public MenuAmount(long amount) {
		validate(amount);
		this.amount = amount;
	}

	private void validate(long count) {
		if (count <= 0 || count >= 100) {
			throw new IllegalArgumentException(String.format("%d 메뉴의 범위를 넘었습니다.", count));
		}
	}

	public MenuAmount addCount(MenuAmount other) {
		return new MenuAmount(this.amount + other.amount);
	}

	public long multiply(int price) {
		return amount * price;
	}

	public long getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "MenuCount{" +
			"count=" + amount +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MenuAmount menuAmount = (MenuAmount)o;
		return amount == menuAmount.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

}

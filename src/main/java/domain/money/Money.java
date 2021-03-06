package domain.money;

import java.util.Objects;

import domain.menu.MenuAmount;

public class Money {
	private final long amount;

	public Money(long amount) {
		validate(amount);
		this.amount = amount;
	}

	private void validate(long amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(String.format("%d 옳바르지 않은 금액입니다.", amount));
		}
	}

	public Money multiply(MenuAmount menuAmount) {
		return multiply(menuAmount.getAmount());
	}

	public Money multiply(double other) {
		return new Money((long)(amount * other));
	}

	public Money addition(Money other) {
		return new Money(amount + other.amount);
	}

	public Money minus(Money other) {
		return new Money(amount - other.amount);
	}

	public long getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Money{" +
			"amount=" + amount +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money = (Money)o;
		return amount == money.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}

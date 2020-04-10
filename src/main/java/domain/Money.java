package domain;

import java.util.Objects;

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
		return new Money(amount * menuAmount.getAmount());
	}

	public Money addition(Money other) {
		return new Money(amount + other.amount);
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

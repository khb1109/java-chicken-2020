package domain;

import java.util.Objects;

public abstract class Payment {
	protected final Money money;

	public Payment(Table table) {
		Objects.requireNonNull(table, "결제할 테이블이 없어요!");
		money = null;
		// 치킨 가격을 할인시킨다!
	}

	abstract public Money calculate();
}

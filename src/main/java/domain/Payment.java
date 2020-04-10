package domain;

import java.util.Objects;

public abstract class Payment {
	protected final long money;

	public Payment(Table table) {
		Objects.requireNonNull(table, "결제할 테이블이 없어요!");
		money = table.totalMoney();
		new Sale(table.findCountOfChicken());
	}

	abstract public long calculate();
}

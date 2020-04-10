package domain;

import java.util.List;
import java.util.Objects;

public class Payment {
	protected final Table table;

	public Payment(Table table) {
		Objects.requireNonNull(table, "테이블이 존재하지 않아요!");
		this.table = table;
	}

	public Money calculate(List<Discount> discounts) {
		Money money = table.totalMoney();
		for (Discount discount : discounts) {
			money = discount.calculateDiscount(money);
		}
		return money;
	}
}

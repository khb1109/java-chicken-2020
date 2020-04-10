package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class PaymentTest {
	@DisplayName("결제 생성 테스트")
	@ParameterizedTest
	@NullSource
	void name(Table table) {
		assertThatThrownBy(() -> new Payment(table) {
			@Override
			public Money calculate(List<Discount> discounts) {
				return new Money(1000);
			}
		}).isInstanceOf(NullPointerException.class);
	}

	@Test
	void calculate() {
		Table table = new Table(1);
		table.addMenu(new Menu(1, "가짜치킨", Category.CHICKEN, new Money(10000)), new MenuAmount(1));
		table.addMenu(new Menu(2, "둘둘치킨", Category.CHICKEN, new Money(20000)), new MenuAmount(1));
		table.addMenu(new Menu(3, "호식이치킨", Category.CHICKEN, new Money(30000)), new MenuAmount(1));

		Payment payment = new Payment(table);

		List<Discount> discounts = Arrays.asList(new Discount() {
			@Override
			protected Money calculateDiscount(Money originMoney) {
				return new Money(10000);
			}
		});

		Money actual = payment.calculate(discounts);

		assertThat(actual).isEqualTo(new Money(10000));
	}
}
package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.MenuAmount;
import domain.money.Money;

class MoneyTest {
	@DisplayName("Money 생성 테스트")
	@Test
	void name() {
		assertThatThrownBy(() -> new Money(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("돈과 숫자를 입력받아 곱셈 결과를 확인")
	@Test
	void multiply() {
		Money money = new Money(1000);
		Money actual = money.multiply(2);

		assertThat(actual).isEqualTo(new Money(2000));
	}

	@DisplayName("돈과 수량을 입력받아 곱셈 결과를 확인")
	@Test
	void testMultiply() {
		Money money = new Money(1000);
		Money actual = money.multiply(new MenuAmount(10));

		assertThat(actual).isEqualTo(new Money(10000));
	}

	@DisplayName("돈과 돈을 더하는 테스트")
	@Test
	void addition() {
		Money money = new Money(1000);
		Money actual = money.addition(new Money(2000));

		assertThat(actual).isEqualTo(new Money(3000));
	}

	@DisplayName("돈과 돈을 뺴는 테스트")
	@Test
	void minus() {
		Money money = new Money(1000);
		Money actual = money.minus(new Money(1000));

		assertThat(actual).isEqualTo(new Money(0));
	}
}
package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.money.ChickenDiscount;
import domain.money.Money;

class ChickenDiscountTest {

	@DisplayName("치킨할인 생성 테스트")
	@Test
	void name() {
		assertThatThrownBy(() -> new ChickenDiscount(-1))
			.isInstanceOf(IllegalArgumentException.class);

	}

	@DisplayName("치킨 할인가격 확인 테스트")
	@Test
	void calculateDiscount() {
		ChickenDiscount chickenDiscount = new ChickenDiscount(10);

		Money actual = chickenDiscount.calculateDiscount(new Money(10000));

		assertThat(actual).isEqualTo(new Money(10000L));
	}
}
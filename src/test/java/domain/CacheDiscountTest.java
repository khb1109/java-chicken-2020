package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.money.CacheDiscount;
import domain.money.Money;

class CacheDiscountTest {

	@DisplayName("현금할인 테스트!")
	@Test
	void discount() {
		Money money = new Money(10000);
		CacheDiscount cacheDiscount = new CacheDiscount();

		Money actual = cacheDiscount.discount(money);

		assertThat(actual).isEqualTo(new Money(9500));
	}
}
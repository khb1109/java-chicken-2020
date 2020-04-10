package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import domain.menu.MenuAmount;

class MenuAmountTest {

	@DisplayName("메뉴 카운트 생성테스트")
	@ParameterizedTest
	@ValueSource(longs = {-1, 100})
	void name(long count) {
		assertThatThrownBy(() -> new MenuAmount(count))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("메뉴 추가 테스트")
	@Test
	void addMenu() {
		MenuAmount menuAmount = new MenuAmount(10);

		MenuAmount actual = menuAmount.addCount(new MenuAmount(10));

		assertThat(actual).isEqualTo(new MenuAmount(20));
	}

	@DisplayName("메뉴카운트의 곱하기 연산 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1,1000", "2, 2000", "3, 3000"})
	void multiply(long count, long expect) {
		MenuAmount menuAmount = new MenuAmount(count);
		long actual = menuAmount.multiply(1000);

		assertThat(actual).isEqualTo(expect);
	}
}
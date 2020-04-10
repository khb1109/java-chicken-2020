package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuCountTest {

	@DisplayName("메뉴 카운트 생성테스트")
	@ParameterizedTest
	@ValueSource(longs = {-1, 100})
	void name(long count) {
		assertThatThrownBy(()-> new MenuCount(count))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("메뉴 추가 테스트")
	@Test
	void addMenu() {
		MenuCount menuCount = new MenuCount(10);

		MenuCount actual = menuCount.addCount(new MenuCount(10));

		assertThat(actual).isEqualTo(new MenuCount(20));
	}
}
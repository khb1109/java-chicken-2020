package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class PaymentTest {
	@DisplayName("결제 생성 테스트")
	@ParameterizedTest
	@NullSource
	void name(Table table) {
		assertThatThrownBy(() -> new Payment(table) {
			@Override
			public long calculate() {
				return 0;
			}
		}).isInstanceOf(NullPointerException.class);
	}
}
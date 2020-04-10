package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {

	@DisplayName("테이블에 메뉴가 없는지 확인")
	@Test
	void hasMenu() {
		Table table = new Table(1);
		assertThat(table.hasMenu()).isFalse();
	}
}
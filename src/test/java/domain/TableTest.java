package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {

	@DisplayName("테이블에 메뉴가 없는지 확인")
	@Test
	void hasMenu() {
		Table table = new Table(1);
		assertThat(table.hasMenu()).isFalse();
	}

	@DisplayName("할인이 되지 않은 총 테이블의 가격을 구한다.")
	@Test
	void totalMoney() {
		Table table = new Table(1);
		table.addMenu(new Menu(1, "가짜치킨", Category.CHICKEN, new Money(10000)), new MenuAmount(1));
		table.addMenu(new Menu(1, "가짜치킨", Category.CHICKEN, new Money(10000)), new MenuAmount(3));
		table.addMenu(new Menu(2, "둘둘치킨", Category.CHICKEN, new Money(20000)), new MenuAmount(1));
		table.addMenu(new Menu(3, "호식이치킨", Category.CHICKEN, new Money(30000)), new MenuAmount(1));

		assertThat(table.totalMoney()).isEqualTo(new Money(90000L));
	}

	@DisplayName("테이블의 치킨의 갯수를 구한다.")
	@Test
	void findCountOfChicken() {
		Table table = new Table(1);
		table.addMenu(new Menu(1, "가짜치킨", Category.CHICKEN, new Money(10000)), new MenuAmount(1));
		table.addMenu(new Menu(1, "가짜치킨", Category.CHICKEN, new Money(10000)), new MenuAmount(3));
		table.addMenu(new Menu(2, "둘둘치킨", Category.CHICKEN, new Money(20000)), new MenuAmount(1));
		table.addMenu(new Menu(3, "호식이치킨", Category.CHICKEN, new Money(30000)), new MenuAmount(1));

		assertThat(table.findCountOfChicken()).isEqualTo(6);
	}
}
package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CategoryTest {

	@Test
	void isChicken() {
		Category category = Category.CHICKEN;
		assertThat(category.isChicken()).isTrue();
	}
}
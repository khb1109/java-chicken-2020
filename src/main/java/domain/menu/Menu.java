package domain.menu;

import java.util.Objects;

import domain.money.Money;

public class Menu {
	private final int number;
	private final String name;
	private final Category category;
	private final Money price;

	public Menu(final int number, final String name, final Category category, final Money price) {
		this.number = number;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Money calculatePrice(MenuAmount menuAmount) {
		return price.multiply(menuAmount);
	}

	public boolean isChicken() {
		return category.isChicken();
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Menu menu = (Menu)o;
		return number == menu.number &&
			price == menu.price &&
			Objects.equals(name, menu.name) &&
			category == menu.category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, name, category, price);
	}

	@Override
	public String toString() {
		return category + " " + number + " - " + name + " : " + price + "원";
	}
}

package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
	private final int number;
	private final Map<Menu, MenuAmount> menus;

	public Table(final int number) {
		this.number = number;
		this.menus = new HashMap<>();
	}

	public boolean hasMenu() {
		return menus.size() > 0;
	}

	//todo: 테스트가 좀 어려운데?
	public void addMenu(Menu menu, MenuAmount menuAmount) {
		if (menus.containsKey(menu)) {
			menus.compute(menu, (Menu findMenu, MenuAmount findMenuAmount) -> findMenuAmount.addCount(menuAmount));
			return;
		}
		menus.put(menu, menuAmount);
	}

	public Money totalMoney() {
		return menus.keySet().stream()
			.map(menu -> menu.calculatePrice(menus.get(menu)))
			.reduce(Money::addition)
			.orElse(new Money(0));
	}

	public long findCountOfChicken() {
		return menus.keySet().stream()
			.filter(Menu::isChicken)
			.map(menus::get)
			.mapToLong(MenuAmount::getAmount)
			.sum();
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}

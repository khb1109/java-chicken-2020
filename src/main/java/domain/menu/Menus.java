package domain.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menus {
	private final Map<Integer, Menu> menus;

	public Menus(List<Menu> menus) {
		this.menus = new HashMap<>();
		for (Menu menu : menus) {
			this.menus.put(menu.getNumber(), menu);
		}
	}

	public Menu findMenu(int menuID) {
		if (menus.containsKey(menuID)) {
			return menus.get(menuID);
		}
		throw new IllegalArgumentException("해당 메뉴가 존재하지 않습니다.");
	}

	public Map<Integer, Menu> getMenus() {
		return menus;
	}
}

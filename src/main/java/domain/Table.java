package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<Menu, MenuCount> menus;

    public Table(final int number) {
        this.number = number;
        this.menus = new HashMap<>();
    }

    public boolean hasMenu() {
        return menus.size() > 0;
    }

    public void addMenu(Menu menu, MenuCount menuCount) {
        menus.computeIfPresent(menu,
            (Menu findMenu, MenuCount findMenuCount) -> findMenuCount.addCount(menuCount)
        );
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}

package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.Table;
import domain.Tables;
import domain.menu.Menu;
import domain.menu.MenuAmount;
import domain.menu.Menus;
import domain.money.Money;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";

	public static void printTables(final Tables tables) {
		List<Table> tablesInfo = new ArrayList<>(tables.getTables().values());
		System.out.println("## 테이블 목록");
		final int size = tablesInfo.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tablesInfo);
		printLine(BOTTOM_LINE, size);
	}

	public static void printMenus(final Menus menus) {
		List<Menu> menuInfo = new ArrayList<>(menus.getMenus().values());
		for (final Menu menu : menuInfo) {
			System.out.println(menu);
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printFunctions() {
		System.out.println("## 메인화면");
		System.out.println("1 - 주문등록");
		System.out.println("2 - 결제하기");
		System.out.println("3 - 프로그램 종료");
	}

	public static void printOrders(Table table) {
		System.out.println("## 주문 내역");
		System.out.println("메뉴 수량 금액");
		Map<Menu, MenuAmount> menus = table.getMenus();
		for (Menu menu : menus.keySet()) {
			System.out.println(String.format("%s %d %d", menu.getName(), menus.get(menu).getAmount(),
				menu.calculatePrice(menus.get(menu)).getAmount()));
		}
	}

	public static void printPaymentMoney(Money result) {
		System.out.println("## 최종 결제할 금액");
		System.out.println(String.format("%d원", result.getAmount()));
	}
}

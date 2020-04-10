import java.util.ArrayList;
import java.util.List;

import domain.Table;
import domain.TableRepository;
import domain.Tables;
import domain.menu.MenuAmount;
import domain.menu.MenuRepository;
import domain.menu.Menus;
import domain.money.CacheDiscount;
import domain.money.ChickenDiscount;
import domain.money.Discount;
import domain.money.Money;
import domain.money.Payment;
import view.InputView;
import view.OutputView;

public class Application {
	// TODO 구현 진행
	private static final Tables tables = new Tables(TableRepository.tables());
	private static final Menus menus = new Menus(MenuRepository.menus());
	private static final int CARD = 1;
	private static final int CACHE = 2;

	public static void main(String[] args) {
		do {
			mainMenu();
		} while (true);
	}

	private static void mainMenu() {
		OutputView.printFunctions();
		int function = InputView.selectFunction();

		if (function == 1) {
			order();
		}
		if (function == 2) {
			payment();
		}
		if (function == 3) {
			System.exit(0);
		}
	}

	private static void order() {
		OutputView.printTables(tables);

		int tableNumber = InputView.selectTable();
		Table table = tables.findTable(tableNumber);

		OutputView.printMenus(menus);
		int menuNumber = InputView.selectMenu();
		long menuAmount = InputView.selectMenuAmount();

		table.addMenu(menus.findMenu(menuNumber), new MenuAmount(menuAmount));
	}

	private static void payment() {
		OutputView.printTables(tables);
		int tableNumber = InputView.selectTable();
		Table table = tables.findTable(tableNumber);
		OutputView.printOrders(table);

		int paymentInfo = InputView.selectPayment();
		List<Discount> discounts = new ArrayList<>();
		discounts.add(new ChickenDiscount(table.findCountOfChicken()));
		if (paymentInfo == CACHE) {
			discounts.add(new CacheDiscount());
		}
		Payment payment = new Payment(table);
		Money result = payment.calculate(discounts);
		OutputView.printPaymentMoney(result);
	}
}

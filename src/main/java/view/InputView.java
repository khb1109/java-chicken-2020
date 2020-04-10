package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int selectFunction() {
		System.out.println("## 원하는 기능을 선택하세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public static int selectTable() {
		System.out.println("## 테이블을 선택하세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public static int selectMenu() {
		System.out.println("## 등록할 메뉴를 선택하세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public static int selectMenuAmount() {
		System.out.println("## 메뉴의 수량을 입력하세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public static int selectPayment(int tableNumber) {
		System.out.println(String.format("## %d번 테이블의 결제를 진행합니다.", tableNumber));
		System.out.println("## 신용카드는 1번, 현금은 2번");
		return Integer.parseInt(scanner.nextLine());
	}
}

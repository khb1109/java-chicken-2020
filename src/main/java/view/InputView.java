package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		return Integer.parseInt(scanner.nextLine());
	}

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

	public static int selectPayment() {
		System.out.println("## 최종 결제할 금액");
		return Integer.parseInt(scanner.nextLine());
	}
}

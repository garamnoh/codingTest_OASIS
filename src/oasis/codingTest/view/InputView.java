package oasis.codingTest.view;

import java.util.Scanner;

import oasis.codingTest.controller.LottoController;

public class InputView {
	
	private Scanner sc = new Scanner(System.in);
	private LottoController controller;
	
	// 뷰 - 로또 구입 금액 입력 화면
	public void inputPriceView(LottoController controller) {
		this.controller = controller;
		// 구매 수량
		int quantity = controller.getQuantity(sc.nextInt());
		sc.nextLine();
		controller.resultQuantity(quantity);
	}
	
	// 당첨 번호 입력 화면
	public void inputWinningNumberView() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		String winningNumber = sc.nextLine();
		controller.resultStatistics(winningNumber);
	}


}

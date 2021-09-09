package oasis.codingTest.view;

import oasis.codingTest.controller.LottoController;

public class LottoView {

	private LottoController controller;
	
	// 뷰 - 메인 뷰
	public void mainView(LottoController controller) {
		this.controller = controller;
		System.out.println("구입금액을 입력해 주세요.");
		controller.inputPrice();
	}
}

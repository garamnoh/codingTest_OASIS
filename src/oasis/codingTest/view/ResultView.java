package oasis.codingTest.view;

import java.util.ArrayList;

import oasis.codingTest.controller.LottoController;

public class ResultView {
	
	private LottoController controller;
	
	// 뷰 - 구입한 로또 수량 및 번호 리스트 출력
	public void resultLottoNumberView(LottoController controller, int quantity) {
		this.controller = controller;
		// 구매 수량 출력
		System.out.println(quantity + "개를 구매했습니다.");
		
		// 로또 번호 리스트 출력
		ArrayList<ArrayList<Integer>> lottoList = controller.resultLottoNumber(quantity);
		for(ArrayList<Integer> list : lottoList) System.out.println(list);
		
		// 당첨 번호 화면 이동
		controller.inputWinningNumber();
	}
	
	// 뷰 - 당첨 통계 결과 및 수익률 출력 화면
	public void resultStatisticView(ArrayList<Object> resultList) {
		System.out.println("\n당첨 통계");
		System.out.println("---------");
		// 당첨 통계 결과 출력
		System.out.println("3개 일치 (5000원)- " + (int)resultList.get(0));
		System.out.println("4개 일치 (50000원)- " + (int)resultList.get(1));
		System.out.println("5개 일치 (1500000원)- " + (int)resultList.get(2));
		System.out.println("6개 일치 (2000000000원)- " + (int)resultList.get(3));
		// 수익률 출력
		System.out.println("총 수익률은 " + (String)resultList.get(4) + "입니다.");
	}
}

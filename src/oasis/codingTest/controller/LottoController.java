package oasis.codingTest.controller;

import java.util.ArrayList;
import java.util.Collections;

import oasis.codingTest.view.InputView;
import oasis.codingTest.view.LottoView;
import oasis.codingTest.view.ResultView;

public class LottoController {
	
	private LottoView view;
	private InputView inputView = new InputView();
	private ResultView resultView = new ResultView();
	private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<ArrayList<Integer>>();
	
	// 변수
	private int three = 0;
	private int four = 0;
	private int five = 0;
	private int six = 0;

	// 컨트롤러 - 메인화면으로 이동
	public void main() {
		view = new LottoView();
		view.mainView(this);
	}
	
	// 컨트롤러 - 로또 구입 금액 입력화면으로 이동
	public void inputPrice() {
		inputView.inputPriceView(this);
	}

	// 컨트롤러 - 로또 구입 수량 계산
	public int getQuantity(int price) {
		// 로또 장당 1000원
		int quantity = price / 1000;
		return quantity;
	}
	
	// 컨트롤러 - 구입한 로또 번호 출력 화면으로 이동
	public void resultQuantity(int quantity) {
		resultView.resultLottoNumberView(this, quantity);
	}
	
	// 컨트롤러 - 구매한 수량 만큼의 로또 번호 리스트 생성
	public ArrayList<ArrayList<Integer>> resultLottoNumber(int quantity) {
		ArrayList<Integer> lottoArr = new ArrayList<Integer>();

		// 로또 번호 생성(1~45)
		for(int i=1; i<=45; i++) lottoArr.add(i);

		// 로또 번호 6개 추출 -> 리스트 생성
		for(int i=0; i<quantity; i++) {
			Collections.shuffle(lottoArr); // 로또 번호 섞어줌
		
			// 리스트 생성
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j=0; j<6; j++) temp.add(lottoArr.get(j)); // 6개 숫자 선택
			Collections.sort(temp); // 정렬
			lottoList.add(temp); // 리스트에 추가
		}
		return lottoList;
	}
	
	// 컨트롤러 - 당첨번호 입력화면으로 이동
	public void inputWinningNumber() {
		inputView.inputWinningNumberView();
	}
	
	// 컨트롤러 - 당첨 통계
	public void resultStatistics(String winningNumber) {
		// 당첨 번호 -> 배열
		String[] numbers = winningNumber.split(", ");
		
		// 일치하는 번호 결과를 담을 리스트 생성
		ArrayList<Object> resultList = checkReduplicationNubmer(numbers);
		
		// 리스트에 수익률 추가
		resultList.add(getRateOfReturn(lottoList.size(), resultList));
		
		resultView.resultStatisticView(resultList);
	}
	
	// 일치하는 번호를 체크해주는 메소드
	public ArrayList<Object> checkReduplicationNubmer(String[] numbers) {
		ArrayList<Object> checkResult = new ArrayList<Object>();
		// 몇 개가 일치하는지 확인 -> 리스트에 추가
		for(ArrayList<Integer> list : lottoList) {
			int count = 0;
			for(int i=0; i<numbers.length; i++) if(list.contains(Integer.parseInt(numbers[i]))) count++;
			
			if(count == 3) three++;
			if(count == 4) four++;
			if(count == 5) five++;
			if(count == 6) six++;
		}
		checkResult.add(three);
		checkResult.add(four);
		checkResult.add(five);
		checkResult.add(six);
		
		return checkResult;
	}
	
	// 수익률 계산 메소드
	public String getRateOfReturn(int quantity, ArrayList<Object> resultList) {
		// 로또를 구매한 가격
		double price = quantity * 1000;
		
		// 수익
		long profit = 0;
		profit += (int)resultList.get(0) * 5000; // 3개 일치
		profit += (int)resultList.get(1) * 50000; // 4개 일치
		profit += (int)resultList.get(2) * 1500000; // 5개 일치
		profit += (int)resultList.get(3) * 2000000000; // 6개 일치
		
		// 수익률
		String rateOfReturn = String.format("%.2f", profit / price);
		
		return rateOfReturn;
	}
}

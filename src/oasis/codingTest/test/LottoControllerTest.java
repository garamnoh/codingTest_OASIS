package oasis.codingTest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import oasis.codingTest.controller.LottoController;

class LottoControllerTest {
	
	LottoController controller = new LottoController();

	// 구매 수량 테스트
	@Test
	void testGetQuantity() {
		assertEquals(1, controller.getQuantity(1000));
	}
	
	// 구매 로또 리스트 테스트
	@Test
	void testResultLottoNumber() {
		assertEquals(2, controller.resultLottoNumber(2).size());
	}
	
	// 당첨번호와 일치하는 번호 리스트 생성 메소드 테스트
	@Test
	void testCheckReduplicationNubmer() {
		assertNotNull(controller.checkReduplicationNubmer("1, 2, 3, 4, 5, 6".split(", ")));
	}
	
	// 수익률 계산 메소드 테스트
	@Test
	void testgetRateOfReturn() {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(1);
		list.add(0);
		list.add(0);
		list.add(0);
		assertEquals(String.format("%.2f", 1.00), controller.getRateOfReturn(5, list));
	}
}

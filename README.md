# codingTest_OASIS
오아시스비즈니스 코딩테스트 - 자동 로또 구현하기

## 1. 구현 기능
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 발급
* 로또 1장의 가격 1,000원
* 지난주 당첨번호 입력하면 당첨 통계 결과 출력
* 총 수익률 계산 및 출력

## 2. 기능 목록 정리
### 2-1. Run
* 프로그램 실행

### 2-2. view
#### 2-2-1. LottoView
* mainView : 메인 화면

#### 2-2-2. InputView
* inputPriceView : 가격입력 화면
* inputWinningNumberView : 당첨번호 입력 화면

#### 2-2-3. ResultView
* resultLottoNumberView : 구매 수량 및 로또 리스트 출력
* resultStatisticView : 당첨 통계 및 수익률 출력

### 2-3. LottoController
* main / inputPrice / resultQuantity / inputWinningNumber : 화면 이동
* getQuantity : 로또 구매 수량 계산
* resultLottoNumber : 구매한 로또 번호 리스트 생성
* resultStatistics : 결과 계산 및 화면 이동
  * checkReduplicationNubmer : 중복 숫자 확인
  * getRateOfReturn : 수익률 계산

### 2-4. LottoControllerTest
* testGetQuantity : 구매 수량 테스트
* testResultLottoNumber : 구매 로또 리스트
* testCheckReduplicationNubmer : 당첨번호와 중복되는 번호 리스트 생성 메소드 테스트
* testgetRateOfReturn : 수익률 계산 메소드 테스트

## 필요 라이브러리
* jUnit

## 결과 화면
![git](https://user-images.githubusercontent.com/61348565/132686383-c8210f18-e4ad-4508-b2a1-c282587cdc67.png)

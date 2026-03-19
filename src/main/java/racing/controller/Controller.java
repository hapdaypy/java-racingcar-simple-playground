package racing.controller;

import racing.domain.Car;
import racing.view.InputView;

import racing.domain.Cars;

public class Controller {
    public static void main(String[] args) {
        // [1] 자동차 이름 및 시도 횟수 입력 받기
        String carNameInput = InputView.inputCarName();
        int trialNumber = InputView.inputTrialNumberCount();


        // [2] 데이터 변환: 문자열 -> 자동차 객체 리스트
        Cars cars = new Cars(carNameInput);
       for (Car car : cars.getCarList()){ // 디버깅용
           System.out.println(car.getName());
       }
        //Race race = new Race(CarManager);

        //[3] 레이씽 경기 시작
       // Race.start(cars,trialNumber);


        //[4] 결과 출력
     //   List<String> winners = Race.getWinners(cars);
     //   OutputView.printWinners(winners);


    }
}
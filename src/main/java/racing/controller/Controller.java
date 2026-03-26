package racing.controller;

import racing.view.InputView;

import racing.domain.Cars;
import racing.domain.Race;
import racing.domain.CarParser;
import racing.domain.Car;
import racing.view.OutputView;
import java.util.List;

public class Controller {
    public void run() {
        // [1] 자동차 이름 및 시도 횟수 입력 받기
        String carNameInput = InputView.inputCarName();
        int trialNumber = InputView.inputTrialNumberCount();
        // [2] 데이터 변환: 문자열 -> 자동차 객체 리스트
        List<Car> carList = CarParser.parse(carNameInput);
        Cars cars = new Cars(carList);
        Race race = new Race(cars,trialNumber);
        //[3] 레이씽 경기 시작
        race.playRound();
        //[4] 결과 출력
        OutputView.printWinners(race.getWinners());

    }
}

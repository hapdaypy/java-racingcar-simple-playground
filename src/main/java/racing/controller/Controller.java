package racing.controller;

import racing.view.InputView;

import racing.domain.Cars;
import racing.domain.Race;
import racing.view.OutputView;

public class Controller {
    public void run() {
        // [1] 자동차 이름 및 시도 횟수 입력 받기
        String carNameInput = InputView.inputCarName();
        int trialNumber = InputView.inputTrialNumberCount();
        // [2] 데이터 변환: 문자열 -> 자동차 객체 리스트
        Cars cars = new Cars(carNameInput);
        Race race = new Race(cars,trialNumber);
        //[3] 레이씽 경기 시작
        race.playRound();
        //[4] 결과 출력
        OutputView.printWinners(race.getWinners());

    }
}
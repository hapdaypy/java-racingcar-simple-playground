package racing.controller;

import racing.view.InputView;
import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) {

        // [1] 자동차 이름 및 시도 횟수 입력 받기
        String carNameInput = InputView.inputCarName();
        int trialNumber = InputView.inputTrialNumberCount();
        System.out.println("입력된 이름: " + carNameInput); //디버깅용
        // [2] 데이터 변환: 문자열 -> 자동차 객체 리스트
        List<Car> cars = createCars(carNameInput);
    }

    private static List<Car> createCars(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}
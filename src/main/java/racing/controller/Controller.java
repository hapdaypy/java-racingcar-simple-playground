package racing.controller;

import racing.view.InputView;
import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void run(){
        //[1] 자동차, 경기진행 횟수 입력
        String carNameInput = InputView.inputCarName();
        int trialNumber = InputView.inputTrialNumberCount();

        //[2] 데이터 변환 : 문자열 -> 자동차 객체 배열
        List<Car> cars = createCars(carNameInput);
    }
    private List<Car> createCars(String input){
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();

        for(String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
}

package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    public static List<Car> createCars(String input) {
        String[] names = input.split(",");
        var cars = new ArrayList<Car>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
    public static void duplicate(List<Car> cars){
        long distinctCount = cars.stream()
                .map(Car::getName) // Car 객체에서 이름을 추출한다고 가정
                .distinct()
                .count();
        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException("[ERROR]중복된 자동차 이름이 존재합니다.");
        }
    }
}

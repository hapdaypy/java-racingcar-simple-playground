package racing.domain;

import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import racing.view.OutputView;

public class Race {
    // 경기 실행후 출력하는 메서드
    private static final int RANDOM_RANGE = 10; // 0~9
    private static final int MOVE_THRESHOLD = 4; // 4 이상일 때 전진
    private static final Random random = new Random();

    public static void start(List<Car> cars, int trialCount) {
        for (int i = 0; i < trialCount; i++) {
            runRound(cars);
            System.out.println(); //
        }
    }

    private static void runRound(List<Car> cars) {
        for (Car car : cars) {
            if (shouldMove()) {
                car.move();
            }
            OutputView.printRoundResult(car);
        }
    }
    private static boolean shouldMove() {
        return random.nextInt(RANDOM_RANGE) >= MOVE_THRESHOLD;
    }

    public static List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

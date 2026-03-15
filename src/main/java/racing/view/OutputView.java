package racing.view;
import racing.domain.Car;
import java.util.List;

public class OutputView {
    public static void printRoundResult(Car car) {
        System.out.println(car.getName() + " : " + car.getPositionVisualized());
    }

    public static void printWinners(List<String> winnerNames) {
        if (winnerNames == null || winnerNames.isEmpty()) {
            return;
        }
        String result = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + result);
    }
}

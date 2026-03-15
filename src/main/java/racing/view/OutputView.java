package racing.view;
import racing.domain.Car;
import java.util.List;

public class OutputView {
    public static void printRoundResult(Car car) {
        int position = car.getPosition();
        StringBuilder visualPath = new StringBuilder();
        for (int i = 0; i < position; i++) {
            visualPath.append("-");
        }
        System.out.println(car.getName() + " : " + visualPath.toString());
    }

    public static void printWinners(List<String> winnerNames) {
        if (winnerNames == null || winnerNames.isEmpty()) {
            return;
        }
        String result = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + result);
    }
}

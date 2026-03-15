package racingcar.view;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME_MASSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String INPUT_CAR_COUNT_MASSAGE = "시도할 회수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarName() {
        System.out.println(INPUT_CAR_COUNT_MASSAGE);
        return scanner.nextLine();
    }

    public static int inputTrialNumberCount() {
        System.out.println(INPUT_CAR_COUNT_MASSAGE);
        String input = scanner.nextLine();
        return parseTrialCount(input);
    }

    private static int parseTrialCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야합니다.");
        }
    }
}

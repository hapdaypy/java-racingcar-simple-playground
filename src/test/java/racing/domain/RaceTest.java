package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTest {

    @Test
    @DisplayName("시도 횟수가 0 이하일 경우 예외가 발생한다.")
    void invalidTrialCount_ThrowsException() {
        Cars cars = new Cars("pobi,woni");
        assertThatThrownBy(() -> new Race(cars, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승자를 정확히 판별한다.")
    void getWinners() {
        Cars cars = new Cars("pobi,woni,jun");
        Race race = new Race(cars, 1);

        race.moveAll(() -> true);

        cars.getCarList().get(0).move();

        List<String> winners = race.getWinners();
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("공동 우승자를 정확히 판별한다.")
    void getWinners_Multiple() {
        Cars cars = new Cars("pobi,woni,jun");
        Race race = new Race(cars, 1);

        race.moveAll(() -> true);

        List<String> winners = race.getWinners();
        assertThat(winners).containsExactly("pobi", "woni", "jun");
    }
}
package racing.domain;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTest {

    @Test
    void 시도_횟수가_0_이하면_예외가_발생한다() {
        Cars cars = new Cars(List.of(new Car("pobi")));

        assertThatThrownBy(() -> new Race(cars, 0, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 모든_라운드가_종료된_후_playRound를_호출하면_예외가_발생한다() {
        Cars cars = new Cars(List.of(new Car("pobi")));
        Race race = new Race(cars, 1, () -> true);

        race.playRound(); // 1라운드 진행 완료

        assertThatThrownBy(race::playRound)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 이미 모든 라운드가 종료되었습니다.");
    }

    @Test
    void 단독_우승자를_정확히_반환한다() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        pobi.move(); // pobi만 1칸 이동

        Cars cars = new Cars(List.of(pobi, crong));
        Race race = new Race(cars, 1, () -> true);

        List<String> winners = race.getWinners();

        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 공동_우승자를_정확히_반환한다() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        // 둘 다 0칸 이동 상태 (동점)

        Cars cars = new Cars(List.of(pobi, crong));
        Race race = new Race(cars, 1, () -> true);

        List<String> winners = race.getWinners();

        assertThat(winners).containsExactly("pobi", "crong");
    }
}
package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 유효한_이름으로_자동차를_생성하면_초기_위치는_0이다() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 이름이_비어있거나_공백만_있으면_예외가_발생한다(String invalidName) {
        assertThatThrownBy(() -> new Car(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 1자 이상이어야 합니다.");
    }

    @Test
    void 이름이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 1자 이상이어야 합니다.");
    }

    @Test
    void 이름이_5자를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 이름에_공백이_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("po bi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름에 공백을 포함할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi!", "crong@", "honx#"})
    void 이름에_특수문자가_포함되면_예외가_발생한다(String invalidName) {
        assertThatThrownBy(() -> new Car(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름에 특수문자를 포함할 수 없습니다.");
    }

    @Test
    void move_호출시_위치가_1_증가하지_않는다면_예외가_발생한다() {
        Car car = new Car("pobi");
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
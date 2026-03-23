package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("문자열을 입력받아 여러 대의 자동차를 생성한다.")
    void create_Cars() {
        Cars cars = new Cars("pobi,woni,jun");
        assertThat(cars.getCarList()).hasSize(3);
        assertThat(cars.getCarList().get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("중복된 이름이 존재할 경우 예외가 발생한다.")
    void create_DuplicateNames_ThrowsException() {
        assertThatThrownBy(() -> new Cars("pobi,pobi,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
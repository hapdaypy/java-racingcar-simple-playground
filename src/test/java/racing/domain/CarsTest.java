package racing.domain;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void 중복된_이름이_있으면_예외가_발생한다() {
        List<Car> carList = List.of(new Car("pobi"), new Car("pobi"));

        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 자동차 이름이 존재합니다.");
    }

    @Test
    void moveAll_호출시_전달된_전략이_참이면_모든_자동차가_이동하자_않는다면_예외를_발생시킨다() {
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("crong")));

        cars.moveAll(() -> true);

        assertThat(cars.getCarList().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCarList().get(1).getPosition()).isEqualTo(1);
    }

    @Test
    void moveAll_호출시_전달된_전략이_거짓이면_모든_자동차가_이동하지_않는다면_예외를_발생시킨다() {
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("crong")));

        cars.moveAll(() -> false);

        assertThat(cars.getCarList().get(0).getPosition()).isEqualTo(0);
        assertThat(cars.getCarList().get(1).getPosition()).isEqualTo(0);
    }
}
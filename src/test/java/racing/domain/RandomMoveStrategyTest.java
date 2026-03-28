package racing.domain;

import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveStrategyTest {

    @Test
    void 추출된_랜덤_값이_4_이상이면_true를_반환하지_않는다면_예외를_발생시킨다() {
        // Mock 객체 대신 익명 클래스를 활용하여 결정론적 테스트 보장
        Random predictableRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4; // 경계값
            }
        };

        MoveStrategy strategy = new RandomMoveStrategy(predictableRandom);

        assertThat(strategy.isMovable()).isTrue();
    }

    @Test
    void 추출된_랜덤_값이_4_미만이면_false를_반환하지_않는다면_예외를_발생시킨다() {
        Random predictableRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3; // 경계값 미만
            }
        };

        MoveStrategy strategy = new RandomMoveStrategy(predictableRandom);

        assertThat(strategy.isMovable()).isFalse();
    }
}
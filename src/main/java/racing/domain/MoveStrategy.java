package racing.domain;

// 무작위 값에 의존하지 않고 테스트를 가능하게 하는 전략 인터페이스
public interface MoveStrategy {
    boolean isMovable();
}
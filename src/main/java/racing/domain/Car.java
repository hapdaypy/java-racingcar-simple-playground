package racing.domain;

public class Car {
    private final String name;
    private int position  = 0;
    private boolean isWinner = false;

    public Car(String name){

        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상이어야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
        // [추가] 이름 중간에 공백이 포함된 경우를 잡아냅니다.
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 공백을 포함할 수 없습니다.");
        }
        // [추가] 정규표현식을 통해 특수문자를 검사합니다 (한글, 영문, 숫자만 허용).
        if (!name.matches("^[a-zA-Z0-9가-힣]*$")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 특수문자를 포함할 수 없습니다.");
        }
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner() {
        return isWinner;
    }

}

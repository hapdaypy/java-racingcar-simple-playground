package racing.domain;

public class Car {
    private final String name;
    private int position  = 0;
    private boolean isWinner = false;

    public Car(String name){
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    public void move() {
        this.position++;
    }

    public String getPositionVisualized() {
        StringBuilder visualPath = new StringBuilder();
        for (int i = 0; i < position; i++) {
            visualPath.append("-");
        }
        return visualPath.toString();
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

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}

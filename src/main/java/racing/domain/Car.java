package racing.domain;

public class Car {
    private final String name;
    private int position  = 0;
    private boolean isWinner = false;

    public Car(String name){
        this.name = name;
    }
}

    package racing.domain;

    import racing.view.OutputView;

    import java.util.List;
    import java.util.stream.Collectors;

    public class Race {
        private final Cars cars;
        private final int trialNumber;

        public Race(Cars cars,int trialNumber){

            this.cars = cars;
            this.trialNumber = trialNumber;
            validateTrialCount(trialNumber);
        }


        public void playRound() {
            MoveStrategy moveStrategy = new RandomMoveStrategy();
            for (int i = 0; i < trialNumber; i++) {
                moveAll(moveStrategy);
                OutputView.printRoundResult(getParticipatingCars());
                OutputView.println();
            }
        }

        public void moveAll(MoveStrategy moveStrategy) {
            for (Car car : cars.getCarList()) {
                if (moveStrategy.isMovable()) {
                    car.move();
                }
            }
        }


        public List<Car> getParticipatingCars() {
            return cars.getCarList();
        }

        public void validateTrialCount(int tryNumber){
            if(tryNumber <= 0){
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1회 이상이여야합니다.");
            }
        }

        public List<String> getWinners() {
            List<Car> carList = cars.getCarList();
            int maxPosition = carList.stream()
                    .mapToInt(Car::getPosition)
                    .max()
                    .orElse(0);

            return carList.stream()
                    .filter(car -> car.getPosition() == maxPosition)
                    .map(Car::getName)
                    .collect(Collectors.toList());
        }
    }

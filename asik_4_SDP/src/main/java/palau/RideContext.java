package palau;

public class RideContext {
    private FareStra fareStrategy;
    private static final double MINIMUM_FARE = 5.00;
    public RideContext(FareStra fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public void setFareStrategy(FareStra fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public void chooseStrategy(String timeOfDay, double distance, double duration) {
        if (timeOfDay.equals("peak") && distance > 2) {
            setFareStrategy(new SurgeFareStra());
        } else if (distance < 2) {
            setFareStrategy(new DiscountFareStra());
        } else {
            setFareStrategy(new RegularFareStra());
        }
    }

    public double calculateFare(double distance, double duration) {
        if (distance <= 0 || duration <= 0) {
            System.out.println("Invalid distance or duration.");
            return 0.0;
        }

        double fare = fareStrategy.calculateFare(distance, duration);
        return Math.max(fare, MINIMUM_FARE);
    }
}


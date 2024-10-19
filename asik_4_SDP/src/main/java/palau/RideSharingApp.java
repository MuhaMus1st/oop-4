package palau;

public class RideSharingApp {
    public static void main(String[] args) {
        RideContext rideContext = new RideContext(new RegularFareStra());
        double fare = rideContext.calculateFare(10, 15);
        System.out.println("Regular Fare: $" + fare);

        rideContext.setFareStrategy(new PremiumFareStra());
        fare = rideContext.calculateFare(10, 15);
        System.out.println("Premium Fare: $" + fare);

        rideContext.setFareStrategy(new SurgeFareStra());
        fare = rideContext.calculateFare(10, 15);
        System.out.println("Surge Fare: $" + fare);

        rideContext.setFareStrategy(new DiscountFareStra());
        fare = rideContext.calculateFare(1, 5);
        System.out.println("Discount Fare: $" + fare);

        rideContext.chooseStrategy("peak", 5, 10);
        fare = rideContext.calculateFare(5, 10);
        System.out.println("Auto-selected Fare: $" + fare);

        fare = rideContext.calculateFare(-5, 10);
        System.out.println("Invalid Fare: $" + fare);
    }
}

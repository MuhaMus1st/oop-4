package palau;

public class RegularFareStra implements FareStra {
    @Override
    public double calculateFare(double distance, double duration) {
        return (distance) + (0.25 * duration);
    }
}

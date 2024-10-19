package palau;

public class PremiumFareStra implements FareStra {
    @Override
    public double calculateFare(double distance, double duration) {
        return (1.50 * distance) + (0.40 * duration);
    }
}

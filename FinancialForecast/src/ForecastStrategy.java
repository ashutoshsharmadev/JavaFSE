public interface ForecastStrategy {
    double calculateFutureValue(double currentValue,
                                double growthRate,
                                int years);
}

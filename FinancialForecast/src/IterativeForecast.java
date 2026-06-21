public class IterativeForecast implements ForecastStrategy{
    @Override
    public double calculateFutureValue(double currentValue,
                                       double growthRate,
                                       int years) {

        for (int i = 0; i < years; i++) {
            currentValue *= (1 + growthRate);
        }

        return currentValue;
    }
}

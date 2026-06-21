public class RecursiveForecast implements ForecastStrategy{
    @Override
    public double calculateFutureValue(double currentValue,
                                       double growthRate,
                                       int years){
        if(years == 0) {
            return currentValue;
        }
        return calculateFutureValue(
                (currentValue * (1 + growthRate)),
                growthRate,
                years - 1
        );
    }
}

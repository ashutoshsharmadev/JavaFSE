//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ForecastStrategy strategy1 = new RecursiveForecast();
        ForecastStrategy strategy2 = new IterativeForecast();


        // Recursion is a  technique where a method that calls itself to solve smaller versions of the problem
        // simplifies problems that can be broken into simpler subproblems
        // here each year takes one call therefor
        // Time complexity = O(n), Space complexity = O(n)
        // for large no. of years recursion crashes as it cannot fit in the stack
        // we can use iterativeForecast to solve this problem
        long startTimeRecursive = System.nanoTime();
        double result1 = strategy1.calculateFutureValue(
                1000,
                0.10,
                10
        );

        long endTimeRecursive = System.nanoTime();
        double durationRecursive = (endTimeRecursive - startTimeRecursive) / 1_000_000.0; // for millisecond conversion
        System.out.println("Future Value using recursive strategy=" + (float) result1 + "took" + durationRecursive + "ms");

        long startTimeIterative = System.nanoTime();
        double result2 = strategy2.calculateFutureValue(
                1000,
                0.10,
                10
        );
        long endTimeIterative = System.nanoTime();
        double durationIterative = (endTimeRecursive - startTimeRecursive) / 1_000_000.0; // for millisecond conversion
        System.out.println("Future Value using recursive strategy=" + (float) result2 + "took" + durationIterative + "ms");
    }
}
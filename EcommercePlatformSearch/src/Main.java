import java.util.Arrays;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

//        Product[] products = {
//                new Product(101, "Laptop", "Electronics"),
//                new Product(102, "Phone", "Electronics"),
//                new Product(103, "Book", "Education"),
//                new Product(104, "Shoes", "Fashion"),
//                new Product(105, "Watch", "Accessories")
//        };

        Product[] products = new Product[100000];

        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(
                    100 + i,
                    "Product" + i,
                    "Category" + (i % 10)
            );
        }


        // binary search requires sorted array
        // Arrays.sort is O(nlogn) time complexity
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        SearchStrategy strategy1 = new LinearSearch();
        long startTimeLinear = System.nanoTime();

        SearchStrategy strategy2 = new BinarySearch();
        long startTimeBinary = System.nanoTime();

        Product result1 = strategy1.search(products, 100004);
        long endTimeLinear = System.nanoTime();

        Product result2 = strategy2.search(products, 100004);
        long endTimeBinary = System.nanoTime();

        long durationLinear = endTimeLinear - startTimeLinear;
        long durationBinary = endTimeBinary - startTimeBinary;

        if(result1 != null) {
            System.out.println(result1.getProductName());
            System.out.println("LinearSearch took :" + durationLinear / 1_000_000.0 + "ms");
            System.out.println("Linear search: O(n) worst case time complexity");
        } else {
            System.out.println("Product not found");
        }

        if(result2 != null) {
            System.out.println(result2.getProductName());
            System.out.println("BinarySearch took :" + durationBinary / 1_000_000.0 + "ms");
            System.out.println("Binary search: O(logn) worst case time complexity");
        } else {
            System.out.println("Product not found");
        }


    }


}
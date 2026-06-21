import java.util.Comparator;
import java.util.Arrays;

public class BinarySearch implements SearchStrategy{
    // binarysearch : search mid-element of the array and its subsequent subarrays in either direction
    // array must be sorted
    @Override
    public  Product search(Product[] products, int productId) {
//        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        // sort shouldn't be implemented here but this is how to sort an array
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) /2;

            if (products[mid].getProductId() == productId) {
                return products[mid];
            }

            if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

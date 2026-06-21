public class LinearSearch implements SearchStrategy{

    @Override
    public Product search(Product[] products, int productId) {

        for (Product product : products) {
            if(product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
}

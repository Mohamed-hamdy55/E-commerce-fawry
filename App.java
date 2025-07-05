import cart.Cart;
import customer.Customer;
import product.ExpirableShippableProduct;
import product.Product;
import product.ShippableProduct;

public class App {
    public static void main(String[] args) throws Exception {
        try{
          /*    test expire date error by edit the expire date to be in past, 
                test not enough quantity error by edit the quantity 
          */
          Product cheese = new ExpirableShippableProduct("Cheese", 100, 10, 0.4, "2025-07-04");
          Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 5, 0.7, "2025-07-07");
          Product tv = new ShippableProduct("TV", 5000, 3, 10);
          Product scratchCard = new Product("Scratch Card", 50, 20);
  
          Customer customer = new Customer("Ali", 10000);

          Cart cart = new Cart();
          cart.add(cheese, 2);
          cart.add(biscuits, 1);
          cart.add(tv, 1);
          cart.add(scratchCard, 1);

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}

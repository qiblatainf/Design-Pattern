// Product interface
interface Product {
    void performAction();
}

// Concrete product: ProductA
class ProductA implements Product {
    @Override
    public void performAction() {
        System.out.println("Product A is performing an action.");
    }
}

// Concrete product: ProductB
class ProductB implements Product {
    @Override
    public void performAction() {
        System.out.println("Product B is performing an action.");
    }
}

// Factory class
class ProductFactory {
    public static Product createProduct(String type) {
        if (type.equalsIgnoreCase("A")) {
            return new ProductA();
        } else if (type.equalsIgnoreCase("B")) {
            return new ProductB();
        }
        return null;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Create products using the factory
        Product productA = ProductFactory.createProduct("A");
        Product productB = ProductFactory.createProduct("B");

        // Use the products
        productA.performAction();
        productB.performAction();
    }
}

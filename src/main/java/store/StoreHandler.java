package store;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreHandler implements Runnable {
    private List<Product> products;
    private SingletonStore store;

    public StoreHandler(List<Product> productList, SingletonStore singletonStore) {
        this.products = new ArrayList<>();
        this.store = singletonStore;
        this.products.addAll(productList);
    }

    @Override
    public void run() {
        try {
            store.insertAllProducts(products);
            store.changeStatusByCategory(Status.ABSENT, CategoryType.METAL);
            store.raisePriceOfAvailableProducts();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

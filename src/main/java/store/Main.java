package store;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        SingletonStore musicStore = SingletonStore.getInstance();
        SingletonStore telephoneStore = SingletonStore.getInstance();
        Product p1 = new Product.Builder().status(Status.ABSENT).title("Behemoth").price(134).categoryType(CategoryType.METAL).build();
        Product p2 = new Product.Builder().status(Status.AVAILABLE).title("Burzum").price(100).categoryType(CategoryType.METAL).build();
        Product p3 = new Product.Builder().status(Status.EXPECTED).title("Bach").price(120).categoryType(CategoryType.CLASSIC).build();
        Product p4 = new Product.Builder().status(Status.AVAILABLE).title("Chopin").price(99).categoryType(CategoryType.CLASSIC).build();

        Product p5 = new Product.Builder().status(Status.EXPECTED).title("Samsung s9").price(1013).categoryType(CategoryType.SMARTPHONE).build();
        Product p6 = new Product.Builder().status(Status.AVAILABLE).title("Iphone 5s").price(1114).categoryType(CategoryType.SMARTPHONE).build();
        Product p7 = new Product.Builder().status(Status.AVAILABLE).title("nokia666").price(110).categoryType(CategoryType.OLD_PHONE).build();
        Product p8 = new Product.Builder().status(Status.ABSENT).title("simens3000").price(113).categoryType(CategoryType.OLD_PHONE).build();
        List<Product> musicProducts = Arrays.asList(p1, p2, p3, p4);
        List<Product> telephoneProducts = Arrays.asList(p5, p6, p7, p8);

        Thread ob = new Thread(new StoreHandler(Collections.unmodifiableList(musicProducts), musicStore));
        ob.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ob = new Thread(new StoreHandler(Collections.unmodifiableList(telephoneProducts), telephoneStore));
        ob.start();
        System.out.println("the process completed successfully.");
    }
}

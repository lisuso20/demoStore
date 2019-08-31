package store;

import java.sql.*;
import java.util.List;

public class SingletonStore {
    private final String URL = "jdbc:mysql://localhost/demoStore?"
            + "user=root&password=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection connect = null;
    private Statement statement = null;

    private static SingletonStore store;

    private SingletonStore() { }

    public static SingletonStore getInstance(){
        if (store == null){
            store = new SingletonStore();
        }
        return store;
    }

    public void insertAllProducts(List<Product> productList) throws SQLException {
            connect = DriverManager.getConnection(URL);
            statement = connect.createStatement();
            productList.stream().forEach(p -> {
                try {
                    insertProduct(p);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            statement.close();
    }

    public void insertProduct(Product product) throws SQLException {
        connect = DriverManager.getConnection(URL);
        statement = connect.createStatement();
        incrementProductByCategory(product.getCategoryType(), statement);
        statement.executeUpdate("insert into products (title, status, price, category) values " +
                "('"+ product.getTitle() +"', '"+product.getStatus()+"', "+product.getPrice()+", '"+ product.getCategoryType() +"');");
        statement.close();
    }
    public void changeStatusByCategory(Status status, CategoryType category) throws SQLException {
        connect = DriverManager.getConnection(URL);
        statement = connect.createStatement();
        statement.executeUpdate("update products set status = '"+ status +"' where category = '"+ category +"';");
        statement.close();

    }
    public void raisePriceOfAvailableProducts() throws SQLException {
        connect = DriverManager.getConnection(URL);
        statement = connect.createStatement();
        statement.executeUpdate("update products set price = (price / 100 * 20) + price where status = '"+ Status.AVAILABLE +"';");
        statement.close();
    }
    private void incrementProductByCategory(CategoryType type, Statement statement) throws SQLException {
        switch (type){
            case METAL: statement.executeUpdate("update music_store set count_products = count_products + 1 where category = 'metal'");
            case CLASSIC: statement.executeUpdate("update music_store set count_products = count_products + 1 where category = 'classic'");
            case OLD_PHONE: statement.executeUpdate("update telephone_store set count_products = count_products + 1 where category = 'old_phone'");
            case SMARTPHONE: statement.executeUpdate("update telephone_store set count_products = count_products + 1 where category = 'smartphone'");
        }
    }
}

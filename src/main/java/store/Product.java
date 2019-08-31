package store;

public class Product {

    private String title;
    private Status status;
    private int price;
    private CategoryType categoryType;

    public Product(Builder builder) {
        this.title = builder.title;
        this.status = builder.status;
        this.price = builder.price;
        this.categoryType = builder.categoryType;
    }

    static class Builder{

        private String title;
        private Status status;
        private int price;
        private CategoryType categoryType;
        public Builder title(String val){
            this.title = val;
            return this;
        }

        public Builder status(Status val){
            this.status = val;
            return this;
        }
        public Builder price(int val){
            this.price = val;
            return this;
        }
        public Builder categoryType(CategoryType val){
            this.categoryType = val;
            return this;
        }
        Product build(){
            return new Product(this);
        }
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }
    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

}

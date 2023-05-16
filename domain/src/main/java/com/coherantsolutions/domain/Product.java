package com.coherantsolutions.domain;
public class Product {

    private String name;
    private double rate;
    private double price;

    public static ProductMaker newProductMaker() {
        return new Product().new ProductMaker();
    }

    public class ProductMaker {
        private String name;
        private double rate;
        private double price;

        private ProductMaker() {
        }

        public ProductMaker setName(String name) {
            this.name = name;
            return this;
        }
        public ProductMaker setPrice(double price) {
            this.price = price;
            return this;
        }
        public ProductMaker setRate(double rate) {
            this.rate = rate;
            return this;
        }
        public Product build() {
            Product.this.name = this.name;
            Product.this.price = this.price;
            Product.this.rate = this.rate;
            return Product.this;
        }
    }
    public String getCategoryName() {
        return name;
    }

    public Double getRate() {
        return rate;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Product name: '%s', Product price: '%s', Product rate: '%s'", name, price, rate);
    }

    public void getInfo() {
        System.out.println("Product name: " + this.getCategoryName() + ", " +  "Product price: " + this.getPrice() + ", " +  "Product rate: " + this.getRate());
    }
}

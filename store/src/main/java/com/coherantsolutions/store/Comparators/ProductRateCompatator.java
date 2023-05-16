package com.coherantsolutions.store.Comparators;
import com.coherantsolutions.domain.Product;
import java.util.Comparator;

public class ProductRateCompatator implements Comparator<Product> {


    public int compare(Product product1, Product product2){
        return product1.getRate().compareTo(product2.getRate());
    }
}
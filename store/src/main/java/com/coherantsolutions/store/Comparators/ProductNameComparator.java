package com.coherantsolutions.store.Comparators;
import com.coherantsolutions.domain.Product;
import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product> {

    public int compare(Product product1, Product product2){
        return product1.getCategoryName().compareTo(product2.getCategoryName());
    }
}

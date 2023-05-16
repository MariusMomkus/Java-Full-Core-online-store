package com.coherantsolutions.domain.categories;
import com.coherantsolutions.domain.Category;

public class FruitCategory extends Category {

    public FruitCategory() {
        super("Fruit category");
    }

    @Override
    public String getCategoryName() {
        return "Fruit category";
    }
}

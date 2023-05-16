package com.coherantsolutions.domain.categories;
import com.coherantsolutions.domain.Category;

public class FoodCategory extends Category {

    public FoodCategory() {
        super("Food category");
    }

    @Override
    public String getCategoryName() {
        return "Food category";
    }
}

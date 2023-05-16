package com.coherantsolutions.domain.categories;
import com.coherantsolutions.domain.Category;

public class BookCategory extends Category {

    public BookCategory() {
        super("Book category");
    }

    @Override
    public String getCategoryName() {
        return "Book category";
    }
}

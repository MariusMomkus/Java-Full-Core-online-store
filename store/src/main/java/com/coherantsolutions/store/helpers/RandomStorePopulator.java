package com.coherantsolutions.store.helpers;
import com.coherantsolutions.domain.Category;
import com.coherantsolutions.domain.Product;
import com.coherantsolutions.store.Store;
import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomStorePopulator {

    Store store;

    public RandomStorePopulator(Store store) {
        this.store = store;
    }

        public void fillStoreRandomly() {

        RandomProductGenerator populator = new RandomProductGenerator();
        Map<Category, Integer> categoryMap = createCategoryMap();

        for (Map.Entry<Category, Integer> entry : categoryMap.entrySet()) {
            Category category = entry.getKey();
            Integer numberOfProducts = entry.getValue();
            for (int i = 0; i < numberOfProducts; i++) {

                Product product = Product.newProductMaker()
                        .setName(populator.getProductName(category.getCategoryName()))
                        .setPrice(populator.getProductPrice())
                        .setRate(populator.getProductRate())
                        .build();
                category.addProductToCategory(product);
            }
            store.addCategoryToList(category);
        }
    }

    public static Map<Category, Integer> createCategoryMap() {
        Map<Category, Integer> categoryMap = new HashMap<>();

        Reflections reflections = new Reflections("com.coherantsolutions.domain.categories");

        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> type : subTypes) {
            try {
                Random random = new Random();
                categoryMap.put(type.getConstructor().newInstance(), random.nextInt( 5)+1);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return categoryMap;
    }
}

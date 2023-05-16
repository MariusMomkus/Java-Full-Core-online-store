package com.coherantsolutions.store.helpers;
import com.github.javafaker.Faker;

public class RandomProductGenerator {

    private final Faker faker = new Faker();

    public String getProductName(String categoryName){
        switch (categoryName) {
            case "Book category":
                return faker.superhero().power();
            case "Food category":
                return faker.programmingLanguage().name();
            case "Fruit category":
                return faker.pokemon().name();
            default:
                return "Other categories";
        }
    }

    public Double getProductPrice (){
        return faker.number().randomDouble(2,1,1000);
    }

    public Double getProductRate(){
        return Double.valueOf(faker.number().numberBetween(0,10));
    }
}

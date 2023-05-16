package com.coherantsolutions.store.helpers;
import com.coherantsolutions.domain.Product;
import com.coherantsolutions.store.Store;
import com.coherantsolutions.store.Comparators.ProductNameComparator;
import com.coherantsolutions.store.Comparators.ProductPriceComparator;
import com.coherantsolutions.store.Comparators.ProductRateCompatator;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;
import java.util.Map;

public class SortHelper {
    Store store;

    public SortHelper(Store store) {
        this.store = store;
    }

    public List<Product> sortedProductList (Map<String, String> configMap ){
        List <Product> allProductList = store.getAllProducts();
        int i = 1;
        for (Map.Entry<String, String> entry : configMap.entrySet()){
            switch (entry.getKey()){
                case "name":
                    if (entry.getValue().equals("asc")){
                        allProductList.sort(new ProductNameComparator());
                        System.out.println();
                        System.out.println(i + ".Sorted by name: " + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }else{
                        allProductList.sort(new ProductNameComparator().reversed());
                        System.out.println();
                        System.out.println(i + ".Sorted by name: " + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }
                i++;
                break;

                case "price":
                    if (entry.getValue().equals("asc")){
                        allProductList.sort(new ProductPriceComparator());
                        System.out.println();
                        System.out.println(i + ".Sorted by price: " + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }else{
                        allProductList.sort(new ProductPriceComparator().reversed());
                        System.out.println();
                        System.out.println(i + ".Sorted by price: " + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }
                    i++;
                    break;

                case "rate":
                    if (entry.getValue().equals("asc")){
                        allProductList.sort(new ProductRateCompatator());
                        System.out.println();
                        System.out.println(i + ".Sorted by rate: " + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }else{
                        allProductList.sort(new ProductRateCompatator().reversed());
                        System.out.println();
                        System.out.println(i + ".Sorted by rate: " + entry.getValue());
                        for (Product product: allProductList){
                            System.out.println(product);
                        }
                    }
                    i++;
                    break;
                default:
                    throw new IllegalStateException("Unexpected sorting value: " + entry.getKey());
            }
            }
        return  allProductList;
        }

       public void TopFiveExpensive (Store store){
            List <Product> allProductList = store.getAllProducts();
                {
                allProductList.sort(new ProductPriceComparator().reversed());
                System.out.println("---Top 5 most expensive products of Online Store---");
                allProductList.stream().limit(5).forEach(System.out::println);
            }
       }

    public void sortByXML (Store store) throws ParserConfigurationException {
        XmlParser parser = new XmlParser();
        Map <String, String > configMap = parser.xmlParser();
            System.out.println(configMap);
            List<Product> productsSortedByXML = sortedProductList(configMap);
            System.out.println();
            System.out.println("---Sorted Products by XML config---");
            for (Product product: productsSortedByXML){
                System.out.println(product);
            }
        }
    }

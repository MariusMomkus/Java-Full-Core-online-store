package com.coherantsolutions.store.Orders;
import com.coherantsolutions.domain.Product;
import com.coherantsolutions.store.Store;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateOrder extends Thread {
    private final Store store = Store.getInstance();
    private  static  int counter = 0;

    @Override
    public void run() {
            counter++;
            Thread.currentThread().setName("orderThread #" + counter);
            System.out.println("Thread name: " + Thread.currentThread().getName());
            Product purchasedProduct = store.getAllProducts().get(new Random().nextInt(5));

            System.out.println("Ordered product: " + purchasedProduct);
            store.getPurchasedProductList().add(purchasedProduct);
            System.out.println(store.getPurchasedProductList());

            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(30));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println(Thread.currentThread().getName());
    }
}

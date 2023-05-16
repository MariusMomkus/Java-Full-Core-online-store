package com.coherantsolutions.store.Commands;
import com.coherantsolutions.store.Orders.CreateOrder;

public class ProductOrder implements StoreCommand{

    @Override
    public void execute()  {

        CreateOrder createOrder = new CreateOrder();
        createOrder.start();
          }
}

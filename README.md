# Java-Full-Core-online-store
Console application - online store

Before start implementation our OnlineStore, we need to prepare project structure and set up dependency manager. To handle our project dependencies and source code build we will use Maven.

Please crete multi-module maven project in Idea, with such modules:

parent (this is general store module)
domain
store
consoleApp


 Store functionality should be based on above principles. Classes to create:

Product with such attributes as [name, rate, price]
Category classes with the name attribute, for each store category [bike, phone, milk] and products list
Store - class that should handle category list
RandomStorePopulator - utility class that will populate out store/category with fake data using Faker lib
StoreApp - class with main method to execute our store scenario. When invoke main method, application should init store with categories and products and pretty print this data. Also, categories should be read dynamically (at runtime), from base category package using reflections lib.


ppend ability user to interact with our store, while sending commands through read stream. Add support of such commands:

sort - products from store according config. In resources folder create xml config file like
<sort>
    <name>asc</name>
    <price>asc</price>
    <rate>desc</rate>
</sort>
Config file can contains from 1 to N fields. Sort should be done using Comparator. Sort and print should not modify default store product lists and their order.

top - print top 5 products of whole store sorted via price desc
quit - exit app




 design patterns:

Singleton;
ChainOfResponsibility;


implement create order functionality. Each order should be processed in separate thread. Whe user select product , generate the random int from 1 to 30, and create thread that will process selected order for selected time, and after it place the product in another collection (for example, purchased goods). And create one more thread, that will be executed periodically, e.g. ones in 2 mins, that will clean up purchased collection.
e Reflection and in memory products storage with database.

You should store categories and products for each category in database tables.
Requirements:
use JDBC
you can select any DB, but for simplicity, you can select H2 database in files mode


implement an HTTP server (use included in java or external lib), that will handle in memory or DB your categories, but you will receive them via HTTP protocol.
Also, you should implement add the product to cart logic in this server, and process this request via HTTP.
Finally, your HTTP service should be secured with basic authentication (credentials can be hardcoded).
For HTTP client-side you also can use the default (included in java) or use RestAssured.

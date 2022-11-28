import java.util.ArrayList;
public class TestOrders {
  public static void main(String[] args) {

    // Menu items
    Item item1 = new Item();
    item1.name = "dripCoffee";
    item1.price = 3.5;

    Item item2 = new Item();
    item2.name = "cappuccino";
    item2.price = 1.5;

    Item item3 = new Item();
    item3.name = "latte";
    item3.price = 4.0;

    Item item4 = new Item();
    item4.name = "mocha";
    item4.price = 4.5;

    // Order variables -- order1, order2 etc.
    Order order1 = new Order();
    order1.name = "Cindhuri";

    Order order2 = new Order();
    order2.name = "Jimmy";

    Order order3 = new Order();
    order3.name = "Noah";

    Order order4 = new Order();
    order4.name = "Sam";

    order2.items.add(item1);
    order2.total += item1.price;

    order3.items.add(item2);
    order3.total += item2.price;

    order4.items.add(item3);
    order4.total += item3.price;

    order4.items.add(item3);
    order4.total += item3.price;

    order4.items.add(item3);
    order4.total += item3.price;

    order1.ready = true;
    order2.ready = true;

    // Application Simnulations
    // Use this example code to test various orders' updates
    System.out.printf("Name: %s\n", order1.name);
    System.out.printf("Total: %s\n", order1.total);
    System.out.printf("Ready: %s\n", order1.ready);

    System.out.printf("Name: %s\n", order2.name);
    System.out.printf("Total: %s\n", order2.total);
    System.out.printf("Ready: %s\n", order2.ready);

    System.out.printf("Name: %s\n", order3.name);
    System.out.printf("Total: %s\n", order3.total);
    System.out.printf("Ready: %s\n", order3.ready);

    System.out.printf("Name: %s\n", order4.name);
    System.out.printf("Total: %s\n", order4.total);
    System.out.printf("Ready: %s\n", order4.ready);
  }
}
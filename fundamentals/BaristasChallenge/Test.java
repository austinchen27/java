import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    Item item1 = new Item("dripCoffee", 3.5);
    Item item1 = new Item("cappuccino", 1.5);
    Item item1 = new Item("latte", 4.0);
    Item item1 = new Item("mocha", 4.5);

    Order order1 = new Order();
    Order order2 = new Order();

    Order order3 = new Order("Cindhuri");
    Order order3 = new Order("Sam");
    Order order3 = new Order("Noah");

    order3.addItem(item1);
    order3.addItem(item2);

    System.out.println(order1.getStatusMessage());

    order1.setReady(true);
    System.out.println(order1.getStatusMessage());

    System.out.println(order1.getOrderTotal());

    order.display();
  }
}
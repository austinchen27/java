import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    
    // ORDER METHODS
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    public void addItem(Item item) {
      items.add(item);
    }

    public String getStatusMessage() {
      if(this.ready == true) {
        return "Your order is ready.";
      }
      return "Thank you for waiting. Your order will be ready soon."
    }

    public double getOrderTotal() {
      double total = 0;
      for(Item item : items) {
        total += item.getPrice();
      }
      return total;
    }

    public void display() {
      System.out.println("Customer Name: " + this.name);
      for(Item item : this.items) {
        System.out.println(item.getName() + " - $" + item.getPrice());
      }
      System.out.println("Total: " + getOrderTotal());
    }

    
    // GETTERS & SETTERS
    public Order() {
      this.name = "guest";
      this.ready = true;
    }

    public Order(String name) {
      this.name = name;
      this.ready = true;
    }

    public Order(String name, boolean ready, ArrayList<Item> items) {
      this.name = name;
      this.ready = ready;
      this.items = items;
    }

    public String getName() {
      return this.name;
    }

    public boolean getReady() {
      return this.ready;
    }

    public ArrayList<Item> getItems() {
      return items;
    }

    public void setReady(boolean ready) {
      this.ready = ready;
    }

}
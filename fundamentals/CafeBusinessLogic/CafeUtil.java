import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {
  int getStreakGoal() {
    int temp = 0;
    int num = 0;
    for(int i = 0; i < 11; i++) {
      temp = i;
      num += temp;
    }
    return num;
  }

  double getOrderTotal(double[] prices) {
    double total = 0;
    for(double price : prices) {
      total += price;
    }
    return total;
  }

  void displayMenu(ArrayList<String> menuItems) {
    for(int i = 0; i < menuItems.size(); i++) {
      System.out.print(i);
      System.out.print(" ");
      System.out.println(menuItems.get(i));
    }
  }
  
  void addCustomer(ArrayList<String> customers) {
    System.out.println("Please enter your name:");
    String userName = System.console().readLine();
    System.out.println("Hello " + userName +". There are currently " 
    + customers.size() + " ahead of you.");
    customers.add(userName);
  }

}
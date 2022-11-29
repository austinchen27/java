import java.util.*;

public class BankAccountTest {
  public static void main(String[] args) {

    BankAccount bankAccount1 = new BankAccount(50, 100);
    BankAccount bankAccount2 = new BankAccount(5, 20);

    bankAccount1.depositIntoCheckings(1000);
    bankAccount1.withdrawAmount(350);

    System.out.println("Your Checkings Balance is $" + bankAccount1.getCheckingBalance());
    System.out.println("Your Savings Balance is $" + bankAccount1.getSavingsBalance());
    System.out.println("Your Account Balance is $" + bankAccount1.showBalance());

    System.out.println("Your Checkings Balance is $" + bankAccount2.getCheckingBalance());
    System.out.println("Your Savings Balance is $" + bankAccount2.getSavingsBalance());
    System.out.println("Your Account Balance is $" + bankAccount2.showBalance());


  }
}
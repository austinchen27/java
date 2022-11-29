import java.util.*;

public class BankAccount {

  private double checkingBalance;
  private double savingsBalance;
  public static int numberOfAccounts = 0;
  public static double totalBalance = 0;

  public BankAccount(double checkingBalance, double savingsBalance) {
    this.checkingBalance = checkingBalance;
    this.savingsBalance = savingsBalance;
    numberOfAccounts++;
    totalBalance += checkingBalance + savingsBalance;
  }

  public double getCheckingBalance() {
    return this.checkingBalance;
  }

  public double getSavingsBalance() {
    return this.savingsBalance;
  }

  public void depositIntoCheckings(double depositIntoCheckings) {
    checkingBalance += depositIntoCheckings;
    totalBalance += depositIntoCheckings;
  }

  public void depositIntoSavings(double depositIntoSavings) {
    savingsBalance += depositIntoSavings;
    totalBalance += depositIntoSavings;
  }

  public void withdrawAmount(double withdrawAmount) {
    if (checkingBalance - withdrawAmount < 0) {
      System.out.println("Insufficient Balance");
    }else{
      checkingBalance -= withdrawAmount;
      totalBalance -= withdrawAmount;
    }
  }
    
  public double showBalance() {
    double accountBalance = checkingBalance + savingsBalance;
    return accountBalance;
  }
}

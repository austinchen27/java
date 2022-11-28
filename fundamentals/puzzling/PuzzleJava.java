// You will need to import the Random library from java.util
import java.util.Random;
import java.util.ArrayList;

// To use methods from the Random library you will need to create an instance of Random
// Random randMachine = new Random();
// From there you can use any of the methods listed in the documentation. For example:
// randMachine.setSeed(35679); <-- you won't need to use this method

// getTenRolls : Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive

class PuzzleJava {
  ArrayList<Integer> getTenRolls() {
    Random randNum = new Random(); // create new instance
    ArrayList<Integer> tenNums = new ArrayList<Integer>(); // create new array
    for (int i = 0; i < 10; i++) {
      tenNums.add(randNum.nextInt(20) + 1);
    }
    return tenNums;
  }

  String randLetter() {
    String alphabetString = "abcdefghijklmnopqrstuvwxyz";
    Random randNum = new Random(); // create new instance
    String [] alphabet = new String[26]; // create new array
    for (int i = 0; i < 26; i++) {
      alphabet[i] = String.valueOf(alphabetString.charAt(i));
    }
    return alphabet[randNum.nextInt(26)];
  }

  String generatePassword() {
    String password = "";
    for(int i = 0; i < 8; i++) {
      password += randLetter();
    }
    return password;
  }

  String getNewPasswordSet(int length) {
    String password = "";
    for(int i = 0; i <= length; i++) {
      password += randLetter();
    }
    return password;
  }

}
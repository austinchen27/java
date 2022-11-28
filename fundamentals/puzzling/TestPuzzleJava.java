import java.util.Random;
import java.util.ArrayList;

public class TestPuzzleJava {

  public static void main(String[] args) {
    PuzzleJava generator = new PuzzleJava();
    ArrayList<Integer> randomRolls = generator.getTenRolls();
    System.out.println(randomRolls);

//
  // Write your other test cases here.
  //
  String randLetter = generator.randLetter();
  System.out.println(randLetter);

  String generatePassword = generator.generatePassword();
  System.out.println(generatePassword);

  String getNewPasswordSet = generator.getNewPasswordSet(7);
  System.out.println(getNewPasswordSet);

  }
}
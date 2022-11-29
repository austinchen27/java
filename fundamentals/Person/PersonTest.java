public class PersonTest {
  public static void main(String[] args) {
    Person person1 = new Person(10, "Person1");
    Person person2 = new Person(11, "Person2");
    Person person3 = new Person(12, "Person3");
    Person person4 = new Person(13, "Person4");
    Person person5 = new Person(14, "Person5");
    System.out.println(Person.peopleCount());
  }
}
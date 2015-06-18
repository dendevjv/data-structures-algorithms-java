package dsalgjava.ch02.lst0205;

public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public void display() {
        System.out.print("    Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Last name: " + lastName + ", First name: " + firstName
                + ", Age: " + age;
    }
}

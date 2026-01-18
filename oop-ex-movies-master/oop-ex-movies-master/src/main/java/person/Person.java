package person;

public class Person {
    private String name;

    public Person(String name) {
        if (name == null) throw new NullPointerException("Name may not be null");
        if (name.isEmpty()) throw new IllegalArgumentException("Name may not be empty");

        this.name = name;
    }

    public String name() {
        return name;
    }
}
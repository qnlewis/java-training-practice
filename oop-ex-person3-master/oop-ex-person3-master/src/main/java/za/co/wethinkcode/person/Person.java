package za.co.wethinkcode.person;

import java.time.LocalDate;

public class Person {
    private final String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        if (name == null) throw new NullPointerException("Name may not be null");
        if (name.isEmpty()) throw new IllegalArgumentException("Name may not be empty");

        LocalDate now = LocalDate.now();
        if (birthDate != null && now.isBefore(birthDate)) {
            throw new IllegalArgumentException("Birth date must be in the past or null");
        }

        this.name = name;
        this.birthDate = birthDate;
    }

    public Person(String name) {
        if (name == null) throw new NullPointerException("Name may not be null");
        if (name.isEmpty()) throw new IllegalArgumentException("Name may not be empty");

        this.name = name;
        this.birthDate = null;
    }

    public String name() {
        return name;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    // Setter-like method to satisfy test expectations
    public void birthDate(LocalDate birthDate) {
        LocalDate now = LocalDate.now();
        if (birthDate != null && now.isBefore(birthDate)) {
            throw new IllegalArgumentException("Birth date must be in the past or null");
        }
        this.birthDate = birthDate;
    }
}
//Done
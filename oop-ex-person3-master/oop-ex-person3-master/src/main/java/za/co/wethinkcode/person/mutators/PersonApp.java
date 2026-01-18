package za.co.wethinkcode.person.mutators;

import java.time.LocalDate;
import za.co.wethinkcode.person.Person;

public class PersonApp {

    public static void main(String[] cmdLineArgs) {
        Person famousDirector = new Person("Ridley Scott", LocalDate.of(1937, 11, 30));
        printPerson(famousDirector);

        LocalDate aNewDate = LocalDate.of(1939, 11, 11);
        famousDirector.birthDate(aNewDate);  // <-- use this method name
        printPerson(famousDirector);
    }

    private static void printPerson(Person p) {
        System.out.println("Person["
                + "name=" + p.name()
                + ", date-of-birth=" + p.birthDate()
                + "]");
    }
}

package za.co.wethinkcode.person;
import java.time.LocalDate;

public class PersonApp{
    public  static  void main(String[] args){
        Person famousDirector = new Person("Ridley Scott", LocalDate.of( 1937, 11, 30 ));
        printPerson( famousDirector );

        famousDirector = new Person("Stanley Kubrick", LocalDate.of( 1928, 7, 26 ));
        printPerson( famousDirector );
    }

    private static void printPerson(Person person) {
        System.out.println("person: " + person.name());
        System.out.println("date of birth: " + person.birthDate());
    }
}
package wethinkcode.person.v2;
import java.time.LocalDate;

public class Person{
    private String name;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public Person( String name, LocalDate birthDate ){
        if( name == null ) throw new NullPointerException( "Name may not be null" );
        if( name.isEmpty() ) throw new IllegalArgumentException( "Name may not be empty" );

        LocalDate now = LocalDate.now();
        if( birthDate != null && now.isBefore( birthDate )){
            throw new IllegalArgumentException( "Birth date must be in the past or null" );
        }

        this.name = name;
        if( birthDate != null ){
            this.birthYear = birthDate.getYear();
            this.birthMonth = birthDate.getMonthValue();
            this.birthDay = birthDate.getDayOfMonth();
        }else{
            this.birthYear = 0;
            this.birthMonth = 0;
            this.birthDay = 0;
        }
    }

    public Person( String name ){
        if( name == null ) throw new NullPointerException( "Name may not be null" );
        if( name.isEmpty() ) throw new IllegalArgumentException( "Name may not be empty" );

        this.name = name;
        this.birthYear = 0;
        this.birthMonth = 0;
        this.birthDay = 0;
    }

    public String name(){
        return name;
    }

    public LocalDate birthDate(){
        return (birthYear == 0)
                ? null
                : LocalDate.of( birthYear, birthMonth, birthDay );
    }
}
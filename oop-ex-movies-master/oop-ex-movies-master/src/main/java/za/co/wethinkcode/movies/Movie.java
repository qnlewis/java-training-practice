package za.co.wethinkcode.movies;

import person.Person;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Duration;

public class Movie {
    private String title;
    private String synopsis;
    private LocalDate releaseDate;
    private Person director;
    private Duration runTime;
    ArrayList<Person> list = new ArrayList();

    public Movie(String title, String synopsis, LocalDate releaseDate, Person director, Duration runTime) {
        /* The title of a movie can not be changed after the instance is created. It is immutable.
        The movie title may not be null or empty.*/

        if (title == null) throw new NullPointerException("The movie title can not be null");
        if (title.isEmpty()) throw new IllegalArgumentException("The movie title can not be empty");
        this.title = title;

        setSynopsis(synopsis);

        if (releaseDate == null) throw new NullPointerException("The movie release date can not be null");
        this.releaseDate = releaseDate;

        if (runTime == null) throw new NullPointerException("The movie runTime can not be null");
        this.runTime = runTime;

        if (director == null) throw new NullPointerException("The movie director can not be null");
        this.director = director;
    }

    //Getters

    public String getTitle() {return title;}
    public String getSynopsis() {return synopsis;}
    public LocalDate getReleaseDate() {return releaseDate;}
    public Person getDirector() {return director;}
    public Duration getRunTime() {return runTime;}

    public void setSynopsis(String synopsis) {
        this.synopsis = (synopsis == null)? "" :synopsis;
    }
    public void setReleaseDate (LocalDate releaseDate){
        if(releaseDate == null){
            throw new NullPointerException("Release date cannot be null");
        }
        if(this.releaseDate.isAfter(LocalDate.now()) &&
                releaseDate.isAfter(LocalDate.now())) {
            this.releaseDate = releaseDate;

        }
    }

    public void setDirector(Person director) {
        if(director == null) {
            throw new NullPointerException("Director cannot be null");
        }
        if(this.releaseDate.isAfter(LocalDate.now())) {
            this.director = director;
        }
    }
    //Movie version 2 add ons
    public boolean isReleased() {
        if (this.releaseDate.isBefore(LocalDate.now())) {
            return true;
        }
        return false;
    }
    public void addActor(Person anActor){
        list.add(anActor);
    }

    public ArrayList<Person> allActors(){
        return  list;
    }

    public int numberofActors(){
        return allActors().toArray().length;
    }

    public String asFormatted() {
        return "Movie title:    "+getTitle()+'\n' +
                "Synopsis:    "+getSynopsis()+'\n' +
                "ReleaseDate:    "+getReleaseDate()+'\n' +
                "Director:    "+getDirector()+'\n' +
                "Run-time:    "+getRunTime()+'\n' +
                "Actors:        " + allActors() + '\n' +
                "Number of Actors" + numberofActors()+ '\n';
    }
    public static void main(String[] args) {
    }
}


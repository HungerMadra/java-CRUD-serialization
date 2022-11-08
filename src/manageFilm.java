//Import Necessary Java Classes
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Create Public Class
public class manageFilm {

    //Initialize Scanner
    Scanner myScanner = new Scanner(System.in);

    //Create an Arraylist of type filmRating called newFilm to hold film objects
    ArrayList<FilmRating> newFilm = new ArrayList<>();

    //Create a hashmap called films that holds a key value pair of String and an Arraylist of Strings
    HashMap<String, ArrayList<String>> films = new HashMap<>();

    //Creating CRUD Method to manage my films
//Create method for creating films
    public void createFilm() {

//Create a String ArrayList to hold movie cast
        ArrayList<String> movieCast = new ArrayList<>();

//Prompt to create a Film
        System.out.println("Would you like to create a film ?");
        System.out.println("Answer Yes or No");

//Store input in Scanner
        String response = myScanner.nextLine();

//While loop to manage responses
        while (response.equals("Yes")) {

//Set newFilm movieName
            System.out.println("Please Enter Movie Name");
            String movieName = myScanner.next();

//Set newFilm movieRating
            System.out.println("Please Enter Movie Rating");
            String movieRating = (myScanner.next());

//Set newFilm movieCast
            System.out.println("Would you like to enter movie cast ?");
            System.out.println("Answer Yes or No");

//Create while loop to add items to movie cast
            String answer = myScanner.next();
            ArrayList<String> castMembers = new ArrayList<>();

            while (answer.equals("Yes")) {
                System.out.println("Enter cast member name");
                String castMember = myScanner.next();
                castMembers.add(castMember);
                System.out.println("Would you like to enter movie cast ?");
                answer = myScanner.next();

                //Reactivate my loop
                if (answer.equals("No")) {
                    movieCast = castMembers;
                    System.out.println("Would you like to create a film ?");
                    System.out.println("Answer Yes or No");
                    Scanner myScanner = new Scanner(System.in);
                    response = myScanner.next();
                }

            }

//Add all this to the newFilm Hashmap And Arraylist of type FilmRating
            films.put(movieName, movieCast);
            FilmRating tempFilm = new FilmRating(movieName, movieRating, movieCast);
            newFilm.add(tempFilm);

        }
        System.out.println(films);
        System.out.println(newFilm);
        Serializer.serializeArray(newFilm);

    }

//Create RUD methods using Hashmaps.


    //Read Method
    public void readFilms() {
        Serializer.deserializeArray();
        System.out.println(newFilm);
    }

//Update Method

    public void updateFilm() {

// Deserialize the data we had stored
        Serializer.deserializeArray();
        System.out.println(newFilm);

//Prompt to kickstart update sequence
        System.out.println("What film will you like to update, enter film name");
        String update = myScanner.next();
        System.out.println("You want to update: " + "Movie Name - " + update + ", Cast - " + films.get(update));
        System.out.println("answer Yes or No");
        String query = myScanner.next();

//Looping through all the films to find the film they want to update
        if (query.equals("Yes")) {
            for (FilmRating film : newFilm) {

//If we find the Film
                if (film.getMovieName().equals(update)) {

//Query to update movie name
                    System.out.println("What would you like to update Movie Name To");
                    film.setMovieName(myScanner.next());

//Query to update movie rating
                    System.out.println("What would you like to update Movie Rating To");
                    film.setRating(myScanner.next());

//Creating new ArrayList to hold cast members
                    ArrayList<String> castMembers2 = new ArrayList<>();

//Query to update movie cast
                    System.out.println("Would you like to update Movie Cast ?");
                    System.out.println("Answer Yes or No");
                    String inquiry = myScanner.next();

//Loop to add movie cast
                    while (inquiry.equals("Yes")) {
                        System.out.println("Enter cast member name");
                        String castMember = myScanner.next();
                        castMembers2.add(castMember);
                        System.out.println("Would you like to enter more cast members ?");
                        inquiry = myScanner.next();
                    }
                    film.setCast(castMembers2);
                    System.out.println(film.toString());
                }
            }


        }
        System.out.println(newFilm);
        Serializer.serializeArray(newFilm);
    }
    //Delete Method

    public void deleteFilm() {

// Deserialize the data we had stored
        Serializer.deserializeArray();
        System.out.println(newFilm);

//Prompt to kickstart delete sequence
        System.out.println("What film will you like to delete, enter film name");
        String delete = myScanner.next();
        System.out.println("You want to update: " + "Movie Name - " + delete + ", Cast - " + films.get(delete));
        System.out.println("answer Yes or No");
        String question = myScanner.next();

        //Looping through all the films to find the film they want to delete
        if (question.equals("Yes")) {
            for (FilmRating film : newFilm) {

//If we find the Film
                if (film.getMovieName().equals(delete)) {
                    newFilm.remove(film);
                }
                System.out.println(newFilm);
            }
            Serializer.serializeArray(newFilm);

        }
    }
}

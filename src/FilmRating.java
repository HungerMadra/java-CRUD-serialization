import java.io.Serializable;
import java.util.ArrayList;

//Declare Attributes using the access modifier private
    public class FilmRating implements Serializable {
    private String movieName;
    private String rating;
    private ArrayList<String> cast;

    public FilmRating(String movieName, String rating, ArrayList<String> cast) {
        this.movieName = movieName;
        this.rating = rating;
        this.cast = cast;
    }

    //Create getters and setters to access private attributes
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    //toString method for printing
    @Override
    public String toString() {
        return "movieName='" + movieName + '\'' +
                ", rating='" + rating + '\'' +
                ", cast=" + cast +
                '}';
    }
}

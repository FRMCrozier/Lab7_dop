/**
 * Средний уровень. Вариант 3. Задание: Вывести данные о фильмах, начинающихся после 18:00
 * и продолжительностью сеанса более 1 часа 40 минут.
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MoviesForCinema implements Serializable {
    private ArrayList<Cinema> movies;
    private static final long serialVersionUD = 1L;

    public MoviesForCinema() {
        this.movies = new ArrayList<>();
    }

    public ArrayList<Cinema> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Cinema> movies) {
        this.movies = movies;
    }

    public boolean add(Cinema movie) {
        return movies.add(movie);
    }

    public MoviesForCinema Sorting(int length, int hours, int minutes) {
        MoviesForCinema temp = new MoviesForCinema();
        for (Cinema movie : movies) {
            if (movie.getLength() > length && movie.getSeansDate().getHour() >= hours && movie.getSeansDate().getMinute() > minutes)
                temp.add(movie);
        }
        return temp;
    }

    @Override
    public String toString() {
        return "MoviesForCinema {" +
                "movies = " + movies +
                '}';
    }

    public ArrayList getFromLoadString(String[] string) {
        ArrayList<Cinema> movie = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            String[] tempStrings = string[i].split("; ");
            int n = 0;
            String title = tempStrings[n].replace("[", "").strip();
            LocalDateTime seansDate = LocalDateTime.parse(tempStrings[n + 1]);
            int length = Integer.parseInt(tempStrings[n + 2]);
            String genre = tempStrings[n + 3];
            int budget = Integer.parseInt(tempStrings[n + 4].replace("]", ""));
            Cinema cinema = new Cinema(title, seansDate, length, genre, budget);
            movie.add(cinema);
        }

        return movie;

    }
}



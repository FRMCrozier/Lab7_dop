import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class MainForSave {


    public static void main(String[] args) throws IOException {

        /**
         * Заполнение фильмов
         */
        Cinema[] movie = new Cinema[3];
        MoviesForCinema movies = new MoviesForCinema();
        ArrayList<Cinema> cinemas = new ArrayList<>();
        movie[0] = new Cinema("Frankenstein 1931", LocalDateTime.of(2022, Month.OCTOBER, 3, 18, 30, 0), 71, "horror", 262007);
        movie[1] = new Cinema("Bride of Frankenstein", LocalDateTime.of(2022, Month.OCTOBER, 3, 19, 40, 0), 75, "horror", 397000);
        movie[2] = new Cinema("Bride of Reanimator", LocalDateTime.of(2022, Month.OCTOBER, 4, 18, 0, 0), 101,"horror", 3000000);
        for (int j = 0; j < movie.length; j++) {
            cinemas.add(movie[j]);
        }
        System.out.println("\nALL MOVIES:");
        System.out.println(cinemas);

        /**
         * Полуение листа
         */
        movies.setMovies(cinemas);
        /**
         * Сериализация и охранение в бинарный файл
         */
        Serializer f = new Serializer();
        f.SaveSerialize("SaveCinema.bin", cinemas);

        /**
         * Очистка
         */
        f.Clear(cinemas);
        System.out.println("\nMOVIES AFTER CLEAR:\n" + cinemas);

        /**
         * Десериализация и загрузка из бинарного файла
         */
        cinemas = f.LoadDeserialize("SaveCinema.bin");
        System.out.println("\nMOVIES AFTER LOAD:\n" + cinemas);



    }

}

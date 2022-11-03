import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cinema implements Serializable {
    public static final int MIN_LENGTH = 30;
    public static final int MAX_LENGTH = 200;
    public static final int MIN_BUDGET = 1000;
    public static final int MAX_BUDGET = 400000000;
    public static final LocalDateTime MIN_DATA = LocalDateTime.now();
    private static final long serialVersionUD = 1L;
    String title = "";
    String genre;
    private int length = 0;
    private int budget = 0;
    LocalDate dt = LocalDate.now();
    LocalDateTime seansDate = LocalDateTime.now();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getSeansDate() {
        return seansDate;
    }

    public void setSeansDate(LocalDateTime seansDate) {
        if (seansDate.isBefore(MIN_DATA))
            this.seansDate = MIN_DATA;
        else
            this.seansDate = seansDate;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        if (length < MIN_LENGTH)
            this.length = MIN_LENGTH;
        else if (length > MAX_LENGTH)
            this.length = MAX_LENGTH;
        else
            this.length = length;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBudget() {
        return this.budget;
    }

    public void setBudget(int budget) {
        if (budget < MIN_BUDGET)
            this.budget = MIN_BUDGET;
        else if (budget > MAX_BUDGET)
            this.budget = MAX_BUDGET;
        else
            this.budget = budget;
    }

    /**
     * Средний уровень. Вариант 3. Поля класса:
     * Название фильма
     * Дата и время сеанса
     * Продолжительность сеанса
     * Жанр
     * Бюджет
     */
    public Cinema() {
    }

    public Cinema(String title, LocalDateTime seansDate, int length, String genre, int budget) {
        setTitle(title);
        setSeansDate(seansDate);
        setLength(length);
        setGenre(genre);
        setBudget(budget);
    }


    @Override
    public String toString()
    {
        String str = title + "; " + seansDate + "; " + length + "; " + genre + "; " + budget;
        return  str;
    }
}

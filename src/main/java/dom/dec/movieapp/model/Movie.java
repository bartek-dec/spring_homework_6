package dom.dec.movieapp.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Movie {

    private static final int currentYear = LocalDate.now().getYear();

    @NotNull(message = "Title cannot be null")
    @Size(min = 1, message = "Title must be at least 1 character long")
    private String title;

    @Min(value = 1900, message = "Year cannot be less than 1900")
    private int year;

    @NotNull(message = "Producer cannot be null")
    @Size(min = 3, message = "Producer must be at least 3 characters long")
    private String producer;

    public Movie(String title, int year, String producer) {
        this.title = title;
        this.year = year;
        this.producer = producer;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}

package model;

public class Movie {
    private String title;
    private String filmDirector;
    private String genre;
    private int year;
    private double rating;

    public Movie(String title, String filmDirector, String genre, int year, double rating) {
        setTitle(title);
        setFilmDirector(filmDirector);
        setGenre(genre);
        setYear(year);
        setRating(rating);
    }

    public Movie(Movie source) {
        setTitle(source.title);
        setFilmDirector(source.filmDirector);
        setGenre(source.genre);
        setYear(source.year);
        setRating(source.rating);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilmDirector() {
        return this.filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return this.title + " " + this.filmDirector + " " +
                this.genre + " " + this.year + " " + this.rating;
    }

}

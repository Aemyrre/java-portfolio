package model;

import java.util.ArrayList;
import java.util.List;

public class MovieStore {
    private List<Movie> movies;

    public MovieStore() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public List<Movie> filterByGenre(String genre) {
        return this.movies.stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    public List<Movie> sortByReleaseYear() {
        return this.movies.stream()
                .sorted((x, y) -> Integer.compare(x.getYear(), y.getYear()))
                .toList();
    }

    public List<Movie> getTopRatedMovies(int value) {
        return this.movies.stream()
                .sorted((x, y) -> Double.compare(y.getRating(), x.getRating()))
                .limit(value)
                .toList();
    }
}

package dom.dec.movieapp.api;

import dom.dec.movieapp.aop.AddMovieAnnotation;
import dom.dec.movieapp.model.Movie;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieApi {

    private List<Movie> movies;

    public MovieApi() {
        this.movies = new ArrayList<>();

        movies.add(new Movie("Zielona Mila", 1999, "Castle Rock Entertainment"));
        movies.add(new Movie("Forest Gump", 1994, "Paramount Pictures"));
        movies.add(new Movie("Gladiator", 2000, "DreamWorks SKG"));
        movies.add(new Movie("Avatar", 2009, "Dune Entertainment"));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping
    @AddMovieAnnotation
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
        movies.add(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

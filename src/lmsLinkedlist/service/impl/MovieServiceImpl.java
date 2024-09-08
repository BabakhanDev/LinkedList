package lmsLinkedlist.service.impl;

import lmsLinkedlist.Actor;
import lmsLinkedlist.Genre;
import lmsLinkedlist.Movie;
import lmsLinkedlist.service.MovieService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements MovieService {
    private List<Movie> movies;

    public MovieServiceImpl(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public List<Movie> findMovieByFullNameOrPartName(String name) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getName().contains(name)) {
                result.add(movie);
            }
        }
        return result;
    }

    @Override
    public List<Movie> findMovieByActorName(String actorName) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getActorFullName().equals(actorName)) {
                    result.add(movie);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public List<Movie> findMovieByYear(LocalDate year) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getYear().equals(year)) {
                result.add(movie);
            }
        }
        return result;
    }

    @Override
    public List<Movie> findMovieByProducer(String producerFullName) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getProducer().getFirstName().equals(producerFullName)) {
                result.add(movie);
            }
        }
        return result;
    }

    @Override
    public List<Movie> findMovieByGenre(Genre genre) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenre() == genre) {
                result.add(movie);
            }
        }
        return result;
    }

    @Override
    public String findRoleByRoleAndMovieName(String actorFullName, String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getActorFullName().equals(actorFullName)) {
                        return actor.getRole();
                    }
                }
            }
        }
        return "Такой роль не найден ";
    }
}

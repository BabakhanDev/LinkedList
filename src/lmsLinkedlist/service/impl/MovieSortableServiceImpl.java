package lmsLinkedlist.service.impl;

import lmsLinkedlist.Movie;
import lmsLinkedlist.service.MovieSortableService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieSortableServiceImpl implements MovieSortableService {
    private List<Movie> movies;

    public MovieSortableServiceImpl(List<Movie> movies) {
        this.movies = movies;
    }
    @Override
    public void sortMovieByName(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Collections.sort(movies, Comparator.comparing(Movie::getName));
        } else {
            Collections.sort(movies, Comparator.comparing(Movie::getName).reversed());
        }
    }


    @Override
    public void sortByYear(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Collections.sort(movies, Comparator.comparing(Movie::getYear));
        } else {
            Collections.sort(movies, Comparator.comparing(Movie::getYear).reversed());
        }
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        if (nameOrLastName.equalsIgnoreCase("firstName")) {
            Collections.sort(movies, Comparator.comparing(movie -> movie.getProducer().getFirstName()));
        } else {
            Collections.sort(movies, Comparator.comparing(movie -> movie.getProducer().getLastName()));
        }

    }
}

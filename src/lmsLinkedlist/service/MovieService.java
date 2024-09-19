package lmsLinkedlist.service;

import lmsLinkedlist.enums.Genre;
import lmsLinkedlist.models.Actor;
import lmsLinkedlist.models.Movie;

import javax.management.relation.Role;
import java.time.LocalDate;
import java.util.List;

public interface MovieService <T,ID>{
    String save (Movie object);
    List<T> getAllMovies();
    T findMovieByFullNameOrPartName(String name);
   T findMovieByActorName(String actorName);
   T findMovieByYear(LocalDate year);
    T findMovieByProducer(String producerFullName);
    T findMovieByGenre(Genre genre);
    ID findRoleByRoleAndMovieName(String actorFullName, String movieName);

}

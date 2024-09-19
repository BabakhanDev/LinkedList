package lmsLinkedlist.service.impl;

import lmsLinkedlist.dao.MuvieDao;
import lmsLinkedlist.dao.impl.MuvieDaoImpl;
import lmsLinkedlist.exception.MyException;
import lmsLinkedlist.models.Actor;
import lmsLinkedlist.enums.Genre;
import lmsLinkedlist.models.Movie;
import lmsLinkedlist.service.MovieService;

import javax.management.relation.Role;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements MovieService {
    private final MuvieDao<Movie,String> muvieDao = (MuvieDao<Movie, String>) new MuvieDaoImpl();

    @Override
    public String save(Movie object) {
        try {
            muvieDao.save(object);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Successfully save";
    }

    @Override
    public List <Movie> getAllMovies() {
        return muvieDao.getAllMovies();
    }

    @Override
    public Object findMovieByFullNameOrPartName(String name) {
       return muvieDao.findMovieByFullNameOrPartName(name);
    }

    @Override
    public Object findMovieByActorName(String actorName) {
       return muvieDao.findMovieByActorName(actorName);
    }

    @Override
    public Object findMovieByYear(LocalDate year) {
    return muvieDao.findMovieByYear(year);
    }

    @Override
    public Object findMovieByProducer(String producerName) {
       return muvieDao.findMovieByProducer(producerName);
            }



    @Override
    public Object findMovieByGenre(Genre genre) {
       return muvieDao.findMovieByGenre(genre);

    }

    @Override
    public Object findRoleByRoleAndMovieName(String actorFullName, String movieName) {
       return muvieDao.findRoleByRoleAndMovieName(actorFullName,movieName);
    }


//    public MovieServiceImpl(List<Movie> movies) {
//        this.movies = movies;
//    }
//
//    @Override
//    public List<Movie> getAllMovies() {
//        return movies;
//    }
//
//    @Override
//    public List<Movie> findMovieByFullNameOrPartName(String name) {
//        List<Movie> result = new ArrayList<>();
//        for (Movie movie : movies) {
//            if (movie.getName().contains(name)) {
//                result.add(movie);
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public List<Movie> findMovieByActorName(String actorName) {
//        List<Movie> result = new ArrayList<>();
//        for (Movie movie : movies) {
//            for (Actor actor : movie.getActors()) {
//                if (actor.getActorFullName().equals(actorName)) {
//                    result.add(movie);
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public List<Movie> findMovieByYear(LocalDate year) {
//        List<Movie> result = new ArrayList<>();
//        for (Movie movie : movies) {
//            if (movie.getYear().equals(year)) {
//                result.add(movie);
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public List<Movie> findMovieByProducer(String producerFullName) {
//        List<Movie> result = new ArrayList<>();
//        for (Movie movie : movies) {
//            if (movie.getProducer().getFirstName().equals(producerFullName)) {
//                result.add(movie);
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public List<Movie> findMovieByGenre(Genre genre) {
//        List<Movie> result = new ArrayList<>();
//        for (Movie movie : movies) {
//            if (movie.getGenre() == genre) {
//                result.add(movie);
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public String findRoleByRoleAndMovieName(String actorFullName, String movieName) {
//        for (Movie movie : movies) {
//            if (movie.getName().equals(movieName)) {
//                for (Actor actor : movie.getActors()) {
//                    if (actor.getActorFullName().equals(actorFullName)) {
//                        return actor.getRole();
//                    }
//                }
//            }
//        }
//        return "Такой роль не найден ";
//    }
}

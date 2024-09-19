package lmsLinkedlist;

import lmsLinkedlist.dao.impl.MuvieDaoImpl;
import lmsLinkedlist.database.Database;
import lmsLinkedlist.enums.Genre;
import lmsLinkedlist.models.Actor;
import lmsLinkedlist.models.Movie;
import lmsLinkedlist.models.Producer;
import lmsLinkedlist.service.MovieService;
import lmsLinkedlist.service.MovieSortableService;
import lmsLinkedlist.service.impl.MovieServiceImpl;
import lmsLinkedlist.service.impl.MovieSortableServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieService movieService = new MovieServiceImpl();
        MovieSortableService movieSortableService = new MovieSortableServiceImpl();
        Producer producer1 = new Producer("Aly", "Barsbek");
        Producer producer2 = new Producer("Kim", "Aleksandr");
        List<Actor> actors1 = List.of(new Actor("Brad Pitt", "Lead Role"), new Actor("Angelina Jolie", "Support Role"),
                new Actor("Jeckie Chan","Lead Role"));
        movieService.save(new Movie("Dospehi", LocalDate.of(1999, 10, 15), Genre.ACTION, producer1, actors1));
        movieService.save(new Movie("Skaska", LocalDate.of(2023, 10, 15), Genre.ROMANE, producer2, actors1));
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Get all movies");
            System.out.println("2. Find movie by name");
            System.out.println("3. Find movie by actor name");
            System.out.println("4. Find movie by year");
            System.out.println("5. Find movie by producer");
            System.out.println("6. Find movie by genre");
            System.out.println("7. Find actor's role by movie name");
            System.out.println("8. Sort movies by name");
            System.out.println("9. Sort movies by year");
            System.out.println("10. Sort movies by producer");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(movieService.getAllMovies());

                    break;

                case 2:
                    System.out.print("Enter movie name: ");
                    String name = scanner.nextLine();
                    System.out.println(movieService.findMovieByFullNameOrPartName(name));

                    break;

                case 3:
                    System.out.print("Enter actor name: ");
                    String actorName = scanner.nextLine();
                    System.out.println(movieService.findMovieByActorName(actorName));

                    break;

                case 4:
                    System.out.print("Enter year (YYYY-MM-DD): ");
                    LocalDate year = LocalDate.parse(scanner.nextLine());
                    System.out.println(movieService.findMovieByYear(year));
                    break;
                case 5:
                    System.out.print("Enter producer FullName: ");
                    String producerFullName = scanner.nextLine();
                    System.out.println(movieService.findMovieByProducer(producerFullName));

                    break;

                case 6:
                    System.out.print("Enter genre (ACTION, COMEDY, etc.): ");
                    Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
                    System.out.println(movieService.findMovieByGenre(genre));
                    break;

                case 7:
                    System.out.print("Enter actor full name: ");
                    String actorFullName = scanner.nextLine();
                    System.out.print("Enter movie name: ");
                    String movieName = scanner.nextLine();
                    System.out.println(movieService.findRoleByRoleAndMovieName(actorFullName, movieName));

                    break;

                case 8:
                    System.out.print("Sort by name (asc/desc): ");
                    String sortOrderName = scanner.nextLine();
                   movieSortableService.sortMovieByName(sortOrderName);
                    break;

                case 9:
                    System.out.print("Sort by year (asc/desc): ");
                    String sortOrderYear = scanner.nextLine();
                   movieSortableService.sortByYear(sortOrderYear);
                    break;

                case 10:
                    System.out.print("Sort by producer (Name/last): ");
                    String sortProducer = scanner.nextLine();
                    movieSortableService.sortByProducer(sortProducer);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");

            }
        }
    }
}
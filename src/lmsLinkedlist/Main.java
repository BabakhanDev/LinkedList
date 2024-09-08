package lmsLinkedlist;

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

        List<Movie> movies = new ArrayList<>();
        MovieService findableService = new MovieServiceImpl(movies);
        MovieSortableService sortableService = new MovieSortableServiceImpl(movies);

        Producer producer1 = new Producer("Aly", "Barsbek");
        List<Actor> actors1 = List.of(new Actor("Brad Pitt", "Lead Role"), new Actor("Angelina Jolie", "Support Role"),
        new Actor("Jeckie Chan","Lead Role"));

        Movie movie1 = new Movie("Fight Club", LocalDate.of(1999, 10, 15), Genre.ACTION, producer1, actors1);
        Movie movie2 = new Movie("Skaska", LocalDate.of(2023, 10, 15), Genre.ROMANE, producer1, actors1);
        movies.add(movie1);
        movies.add(movie2);

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
                    List<Movie> allMovies = findableService.getAllMovies();
                    allMovies.forEach(m -> System.out.println(m.getName()));
                    break;

                case 2:
                    System.out.print("Enter movie name: ");
                    String name = scanner.nextLine();
                    List<Movie> foundMovies = findableService.findMovieByFullNameOrPartName(name);
                    foundMovies.forEach(m -> System.out.println(m.getName()));
                    break;

                case 3:
                    System.out.print("Enter actor name: ");
                    String actorName = scanner.nextLine();
                    List<Movie> moviesByActor = findableService.findMovieByActorName(actorName);
                    moviesByActor.forEach(m -> System.out.println(m.getName()));
                    break;

                case 4:
                    System.out.print("Enter year (YYYY-MM-DD): ");
                    LocalDate year = LocalDate.parse(scanner.nextLine());
                    List<Movie> moviesByYear = findableService.findMovieByYear(year);
                    moviesByYear.forEach(m -> System.out.println(m.getName()));
                    break;
                case 5:
                    System.out.print("Enter producer full name: ");
                    String producerFullName = scanner.nextLine();
                    List<Movie> moviesByProducer = findableService.findMovieByProducer(producerFullName);
                    moviesByProducer.forEach(m -> System.out.println(m.getName()));
                    break;

                case 6:
                    System.out.print("Enter genre (ACTION, COMEDY, etc.): ");
                    Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
                    List<Movie> moviesByGenre = findableService.findMovieByGenre(genre);
                    moviesByGenre.forEach(m -> System.out.println(m.getName()));
                    break;

                case 7:
                    System.out.print("Enter actor full name: ");
                    String actorFull = scanner.nextLine();
                    System.out.print("Enter movie name: ");
                    String movieName = scanner.nextLine();
                    String role = findableService.findRoleByRoleAndMovieName(actorFull, movieName);
                    System.out.println("Role: " + role);
                    break;

                case 8:
                    System.out.print("Sort by name (asc/desc): ");
                    String sortOrderName = scanner.nextLine();
                    sortableService.sortMovieByName(sortOrderName);
                    movies.forEach(m -> System.out.println(m.getName()));
                    break;

                case 9:
                    System.out.print("Sort by year (asc/desc): ");
                    String sortOrderYear = scanner.nextLine();
                    sortableService.sortByYear(sortOrderYear);
                    movies.forEach(m -> System.out.println(m.getName() + " - " + m.getYear()));
                    break;

                case 10:
                    System.out.print("Sort by producer (firstName/lastName): ");
                    String sortProducer = scanner.nextLine();
                    sortableService.sortByProducer(sortProducer);
                    movies.forEach(m -> System.out.println(m.getName() + " - Producer: " + m.getProducer().getFirstName()));
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
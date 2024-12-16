package src.main.Week3.libraries;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookStorage {
    public static List<Book> storage = new ArrayList<>();
    public static List<Renter> renters = new ArrayList<>();

    public void addBook(Book book) {
        storage.add(book);
    }

    List<Book> getAllBooks() {
        return storage;
    }

    public List<Book> getAllNovels() {
        return storage.stream()
                .filter(value -> Genre.NOVEL.equals(value.genre))
                .collect(Collectors.toList());
    }

    public List<Book> getAllDetective() {
        return storage.stream()
                .filter(value -> Genre.DETECTIVE.equals(value.genre))
                .collect(Collectors.toList());
    }

    public List<Book> getAllRomans() {
        return storage.stream()
                .filter(value -> value.genre.equals(Genre.ROMAN))
                .collect(Collectors.toList());
    }

    public void rent(Renter renter, Book book) {
        if (!book.isRent) {
            book.isRent = true;
            LocalDate rentDate = LocalDate.now();
            LocalDate dueDate = rentDate.plusDays(7);
            book.rentInfo = new RentInfo(book, renter, rentDate, dueDate, false, 0.0);
            renter.infoList.add(book.rentInfo);
            book.rentInfo.printRentInfo();
            renters.add(renter);
        } else {
            System.out.println("Извините книга уже арендована, ниже информация по аренде");
            System.out.println(book.rentInfo);
        }
    }
    void printRenterInfo() {
        renters.forEach(value -> value.printRentHistory());
    }
}


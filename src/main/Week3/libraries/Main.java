package src.main.Week3.libraries;

public class Main {
    public static void main(String[] args) {
        BookStorage bookStorage = new BookStorage();
        Renter renter = new Renter("Игорян", 1);
        bookStorage.addBook(new Novel("Daria Dontsova", "Moegenshtern"));
        Book firstBook = BookStorage.storage.get(0);
        bookStorage.rent(renter, firstBook);
        System.out.println();
        System.out.println();
        renter.printRentHistory();
    }
}

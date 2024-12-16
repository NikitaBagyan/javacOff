package src.test.Week3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.main.Week3.libraries.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTests {

    private BookStorage bookStorage;
    private Renter renter;

    @BeforeEach
    void setUp() {
        bookStorage = new BookStorage();
        renter = new Renter("Игорян", 1);
        BookStorage.storage.clear();
    }

    @Test
    @DisplayName("Успешная аренда книги")
    void testRentBookSuccess() {
        Book book = new Novel("Daria Dontsova", "Moegenshtern");
        bookStorage.addBook(book);

        // Арендуем книгу
        bookStorage.rent(renter, book);

        assertTrue(book.isRent);
        assertNotNull(book.rentInfo);
        assertEquals(book, book.rentInfo.book);
        assertEquals(renter, book.rentInfo.renter);
        assertTrue(renter.infoList.contains(book.rentInfo));
    }

    @Test
    @DisplayName("Арендуем арендную книгу")
    void testRentAlreadyRentedBook() {
        Book book = new Novel("Daria Dontsova", "Moegenshtern");
        bookStorage.addBook(book);

        // Арендуем книгу один раз
        bookStorage.rent(renter, book);

        // Повторная аренда
        Renter newRenter = new Renter("Новый арендатор", 2);
        bookStorage.rent(newRenter, book);

        // Проверяем, что аренда не изменилась
        assertTrue(book.isRent);
        assertEquals(renter, book.rentInfo.renter);
        assertFalse(newRenter.infoList.contains(book.rentInfo));
    }

    @Test
    @DisplayName("Получаем все новеллы")
    void testGetAllNovels() {
        bookStorage.addBook(new Novel("Novel Book 1", "Author A"));
        bookStorage.addBook(new Detective("Detective Book", "Author B"));
        bookStorage.addBook(new Novel("Novel Book 2", "Author C"));

        List<Book> novels = bookStorage.getAllNovels();

        assertEquals(2, novels.size());
        assertEquals("Novel Book 1", novels.get(0).name);
        assertEquals("Novel Book 2", novels.get(1).name);
    }

    @Test
    @DisplayName("История всех аренд")
    void testGetRentHistory() {
        Book book1 = new Novel("Novel Book 1", "Author A");
        Book book2 = new Detective("Detective Book", "Author B");
        bookStorage.addBook(book1);
        bookStorage.addBook(book2);

        // Арендуем книги
        bookStorage.rent(renter, book1);
        bookStorage.rent(renter, book2);

        assertEquals(2, renter.infoList.size());
        assertEquals(book1, renter.infoList.get(0).book);
        assertEquals(book2, renter.infoList.get(1).book);
    }

    @Test
    @DisplayName("Проверяем просроченную аренду")
    void testLateReturnPenalty() {
        Book book = new Novel("Late Novel", "Late Author");
        bookStorage.addBook(book);

        // Устанавливаем дату аренды и просрочку
        LocalDate rentDate = LocalDate.now().minusDays(10);
        LocalDate dueDate = rentDate.plusDays(7);  // Просрочка на 3 дня
        book.rentInfo = new RentInfo(book, renter, rentDate, dueDate, false, 10.0);

        // Рассчитываем просрочку в днях
        long overdueDays = LocalDate.now().toEpochDay() - dueDate.toEpochDay();
        double expectedPenalty = 10.0 * overdueDays;

        // Проверяем calculatePenalty() вместо totalPenalty
        assertEquals(expectedPenalty, book.rentInfo.calculatePenalty(), "Штраф за просрочку не соответствует ожиданиям.");
    }

}


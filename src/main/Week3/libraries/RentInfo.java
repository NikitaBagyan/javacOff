package src.main.Week3.libraries;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentInfo {
    public Book book;
    public Renter renter;
    LocalDate rentDate;
    LocalDate dueDate;
    boolean isReturned;
    public double totalPenalty = 10.0;//10 рублей в день за просрочку


    public RentInfo(Book book, Renter renter, LocalDate rentDate, LocalDate dueDate, boolean isReturned, double totalPenalty) {
        this.book = book;
        this.renter = renter;
        this.rentDate = rentDate;
        this.dueDate = dueDate;
        this.isReturned = isReturned;
        this.totalPenalty = totalPenalty;
    }

    public double calculatePenalty() {
        if (!isReturned && LocalDate.now().isAfter(dueDate)) {
            long overdueDays = LocalDate.now().toEpochDay() - dueDate.toEpochDay();
            return overdueDays * totalPenalty;  // 10 рублей за день
        }
        return 0.0;
    }


    void printRentInfo() {

        StringBuilder info = new StringBuilder();
        info.append("\nВы успешно арендовали книгу, поздравляю =)")
                .append("\nКнигу требуется вернуть до ").append(book.rentInfo.dueDate)
                .append("\nВзял в аренду: ").append(book.rentInfo.renter.name)
                .append("\nСтатус аренды: ").append(LocalDate.now().isAfter(book.rentInfo.dueDate) ? "Просрочена" : "Ожидает возврата");
        System.out.println(info);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Информация об аренде:\n");
        info.append("Книга: ").append(book != null ? book.name : "Неизвестно").append("\n");
        info.append("Арендатор: ").append(renter != null ? renter.name : "Неизвестно").append("\n");
        info.append("Дата аренды: ").append(rentDate != null ? rentDate : "Не указано").append("\n");
        info.append("Дата возврата: ").append(dueDate != null ? dueDate : "Не указано").append("\n");
        info.append("Статус аренды: ").append(isReturned ? "Возвращено" : "В аренде").append("\n");

        if (!isReturned && LocalDate.now().isAfter(dueDate)) {
            info.append("Просрочено! Штраф: ").append(calculatePenalty()).append(" руб.\n");
        } else {
            info.append("Штраф: ").append(totalPenalty).append(" руб.\n");
        }
        return info.toString();
    }
}

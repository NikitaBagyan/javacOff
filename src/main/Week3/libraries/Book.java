package src.main.Week3.libraries;

import java.util.EnumSet;

public abstract class Book {

    public String name;

    String author;

    public Genre genre;

    public boolean isRent;

    public RentInfo rentInfo;

    EnumSet<Genre> genres = EnumSet.noneOf(Genre.class);


    public Book(String name, String author, Genre genre) {
        this.name = name;
        this.author = author;
        this.isRent = false;
        if (genre != null) {
            genres.add(genre);
        }
    }
    public void addGenre(Genre genre) {
        if (genre != null) {
            genres.add(genre);
        }
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
    }

    public boolean hasGenre(Genre genre) {
        return genres.contains(genre);
    }

    String getBookInfo() {
        return "Название " + name + " автор книги " + author + " жанр " + genre.getDisplayName();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Книга: ").append(name)
                .append("\nАвтор: ").append(author)
                .append("\nЖанр: ").append(genre == null ? "не указан" : genre.getDisplayName())
                .append("\nСтатус аренды: ").append(isRent ? "в аренде" : "доступна");

        if (isRent && rentInfo != null) {
            info.append("\nИнформация об аренде:\n").append(rentInfo);
        }

        return info.toString();
    }
}

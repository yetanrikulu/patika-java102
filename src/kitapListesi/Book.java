package kitapListesi;

import java.util.Date;

public class Book {

    String name;
    int page;
    String authorName;
    int publishYear;

    public Book(String name, int page, String authorName, int publishYear) {
        this.name = name;
        this.page = page;
        this.authorName = authorName;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPage() {
        return page;
    }
}

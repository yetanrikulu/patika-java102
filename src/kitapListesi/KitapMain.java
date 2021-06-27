package kitapListesi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KitapMain {

    public static void main(String[] args) {

        List<Book> bookList = addBooks();
        Map<String,String> nameAndAuthor = new HashMap<>();

        bookList.stream().forEach(book -> nameAndAuthor.put(book.getName(),book.getAuthorName()));

        List<Book> newBookList = new ArrayList<>();
        bookList.stream().filter(book -> book.getPage()>100).forEach(book -> newBookList.add(book));
    }

    public static List<Book> addBooks(){
        List<Book> bookList = new ArrayList<>();

        Book b = new Book("Kayıp Tanrılar Ülkesi", 504, "Ahmet Ümit", 2021);
        bookList.add(b);

        b = new Book("Balıkçı ve oğlu", 140, "Zülfü Livaneli", 2021);
        bookList.add(b);

        b = new Book("Hayvan Çiftliği", 152, "George Orwell", 2020);
        bookList.add(b);

        b = new Book("Kan Varsa", 432, "Stephen King", 2021);
        bookList.add(b);

        b = new Book("Hesap Lütfen", 272, "Vedat Milor", 2021);
        bookList.add(b);

        b = new Book("Suç ve Ceza", 687, "Dostoyevski", 2020);
        bookList.add(b);

        b = new Book("1984", 352, "George Orwell", 2019);
        bookList.add(b);

        b = new Book("Veba Geceleri", 544, "Orhan Pamuk ", 2021);
        bookList.add(b);

        b = new Book("Kürk Mantolu Madonna", 160, "Sabahattin Ali ", 2019);
        bookList.add(b);

        b = new Book("Şeker Portakalı", 182, "Jose Mauro De Vasconcelos ", 2019);
        bookList.add(b);

        return bookList;
    }
}

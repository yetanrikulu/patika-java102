package kitapSiralayici;

import java.util.*;

public class BookMain {
    public static void main(String[] args) {

        TreeSet<Book> set = new TreeSet<>();

        set.add(new Book("Kayıp Tanrılar Ülkesi","Ahmet Ümit",504,"2021"));
        set.add(new Book("Balıkçı ve oğlu","Zülfü Livaneli",140,"2021"));
        set.add(new Book("Körlük","Jose Saramago ",336,"2021"));
        set.add(new Book("Fareler ve İnsanlar","John Steinbeck",111,"2020"));
        set.add(new Book("Babaannem Geri Döndü","Şermin Yaşar ",160,"2021"));

        System.out.println("İsme göre Sıralama");
        for (Book book : set)
        {
            book.printBook();
        }

        TreeSet<Book> pageSet = new TreeSet<>(new BookPageNumberComparator());

        pageSet.addAll(set);
        System.out.println("---------------------------------");
        System.out.println("Sayfa sayısına göre Sıralama");

        for (Book book : pageSet)
        {
            book.printBook();
        }



    }
}

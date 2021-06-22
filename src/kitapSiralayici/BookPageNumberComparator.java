package kitapSiralayici;

import java.util.Comparator;

public class BookPageNumberComparator implements Comparator<Book> {


    @Override
    public int compare(Book o1, Book o2) {
        return o1.sayfaSayisi-o2.sayfaSayisi;
    }
}

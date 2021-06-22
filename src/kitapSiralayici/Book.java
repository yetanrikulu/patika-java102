package kitapSiralayici;

import java.util.Date;

public class Book implements Comparable<Book> {
    String kitapIsmi;
    String yazarIsmi;
    int sayfaSayisi;
    String yayinTarihi;


   @Override
    public int compareTo(Book o) {
        if (this.kitapIsmi.compareTo(o.kitapIsmi) <0)
            return -1;
        else
            return 1;
    }

    public Book(String kitapIsmi, String yazarIsmi, int sayfaSayisi, String yayinTarihi) {
        this.kitapIsmi = kitapIsmi;
        this.yazarIsmi = yazarIsmi;
        this.sayfaSayisi = sayfaSayisi;
        this.yayinTarihi = yayinTarihi;
    }

    public void printBook (){
        System.out.println("Kitap : " + this.kitapIsmi + "\t||Yazar : " + this.yazarIsmi + "\t||Sayfa Sayısı : "+ this.sayfaSayisi + "\t||Yayin Tarihi : "+ this.yayinTarihi);
    }
}

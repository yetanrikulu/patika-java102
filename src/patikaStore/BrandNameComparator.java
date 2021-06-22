package patikaStore;

import kitapSiralayici.Book;

import java.util.Comparator;

public class BrandNameComparator implements Comparator<Brand> {
    @Override
    public int compare(Brand o1, Brand o2) {
        return o1.name.compareTo(o2.name);
    }
}

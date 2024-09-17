package kdu.backend3;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        if (book1.getYear() != book2.getYear()) {
            return Integer.compare(book1.getYear(), book2.getYear());
        } else {
            return book1.getTitle().compareTo(book2.getTitle());
        }
    }
}

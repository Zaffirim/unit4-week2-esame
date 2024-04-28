package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BibliographicCatalog {

    private List<LibraryItem> catalogItems;

    public BibliographicCatalog(LibraryItem item) {
        catalogItems = new ArrayList<>();
        addItem(item);
    }

    public BibliographicCatalog() {
        catalogItems = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        catalogItems.add(item);
    }

    public void removeItem(String ISBN) {
        catalogItems.removeIf(item -> item.getISBN().equals(ISBN));
    }

    public Optional<LibraryItem> searchByISBN(String ISBN) {
        return catalogItems.stream().filter(item -> item.getISBN().equals(ISBN)).findFirst();
    }

    public List<Book> searchByAuthor(String author) {
        return catalogItems.stream().filter(item -> item instanceof Book).map(item -> (Book) item).filter(book -> book.getAuthor().equals(author)).toList();
    }

    public List<LibraryItem> searchByYear(int publicationYear) {
        return catalogItems.stream().filter(item -> item.getPublicationYear() == publicationYear).toList();
    }




}

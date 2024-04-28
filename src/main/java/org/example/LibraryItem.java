package org.example;

public abstract class LibraryItem {

    protected String ISBN;
    protected String title;
    protected int publicationYear;
    protected int numberOfPages;

    public LibraryItem(String ISBN, String title, int publicationYear, int numberOfPages) {
        this.ISBN = ISBN;
        this.title = title;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }
}

package org.example;

import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("9780123456789", "Libro 1", 2021, 200, "Autore 1", "Genere 1");
        Book book2 = new Book("9789876543210", "Libro 2", 2022, 150, "Autore 2", "Genere 2");

        Magazine magazine1 = new Magazine("1234567890", "Rivista 1", 2021, 50, Frequency.MONTHLY);
        Magazine magazine2 = new Magazine("0987654321", "Rivista 2", 2022, 60, Frequency.WEEKLY);

        BibliographicCatalog catalog = new BibliographicCatalog(book1);

        catalog.addItem(book2);
        catalog.addItem(magazine2);
        catalog.addItem(magazine1);

        //ricerca per ISBN
        String searchISBN = "9780123456789";

        Optional<LibraryItem> foundItem = catalog.searchByISBN(searchISBN);
        if (foundItem.isPresent()) {
            System.out.println("Elemento trovato per ISBN " + searchISBN + ":");
            System.out.println(foundItem.get());
        } else {
            System.out.println("Nessun elemento trovato per ISBN " + searchISBN);
        }

        //Ricerca per Autore

        String searchAuthor = "Autore 2";
        List<Book> booksByAuthor = catalog.searchByAuthor(searchAuthor);
        if (!booksByAuthor.isEmpty()) {
            System.out.println("Libri trovati per autore " + searchAuthor + ":");
            for (Book book : booksByAuthor) {
                System.out.println(book);
            }
        } else {
            System.out.println("Nessun libro trovato per autore " + searchAuthor);
        }

        // Ricerca per anno di pubblicazione
        int searchYear = 2022;
        List<LibraryItem> itemsByYear = catalog.searchByYear(searchYear);
        if (!itemsByYear.isEmpty()) {
            System.out.println("Elementi trovati per anno di pubblicazione " + searchYear + ":");
            for (LibraryItem item : itemsByYear) {
                System.out.println(item);
            }
        } else {
            System.out.println("Nessun elemento trovato per anno di pubblicazione " + searchYear);
        }

    }
}
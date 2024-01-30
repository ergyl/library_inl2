package se.yrgo.library.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import se.yrgo.library.models.*;

public class BookCatalogTest {

    private BookCatalog bc;
    private Book book1;

    public BookCatalogTest() {
        bc = new BookCatalog();
        book1 = new Book(1, "Learning Java", "", "", "", 0);
        bc.addBook(book1);
    }

    //G
    @Test
    public void testAddABook() {
        System.out.println("Starting testAddABook...");
        var b2 = new Book(2, "jUnit", "", "", "", 0);

        System.out.println("Current number of books in book catalog: " + bc.getNumberOfBooks());
        assertEquals(1, bc.getNumberOfBooks());
        System.out.println("Book at index 0: " + bc.getBookArray()[0]);
        assertTrue(bc.getBookArray()[0] == book1);

        bc.addBook(b2);
        System.out.println("Added a book...");
        System.out.println("Current number of books in book catalog: " + bc.getNumberOfBooks());
        assertEquals(2, bc.getNumberOfBooks());
        System.out.println("Book at index 1: " + bc.getBookArray()[1]);
        assertTrue(bc.getBookArray()[1] == b2);
    }

    //G
    @Test
    public void testFindBook() {
        try {
            bc.findBook("Learning Java");
        } catch (BookNotFoundException ex) {
        fail("BookNotFoundException was thrown!");
        }

    }

    //G
    @Test
    public void testFindBookIgnoringCase() {
        try {
            bc.findBook("LEARNING JAVA");
        } catch (BookNotFoundException ex) {
            fail("BookNotFoundException was thrown!");
        }
    }

    //G
    @Test
    public void testFindBookWithExtraSpaces() {
        try {
            bc.findBook(" Learning Java  ");
        } catch (BookNotFoundException ex) {
            fail("BookNotFoundException was thrown!");
        }
    }

    //VG
    // This test should throw BookNotFoundException in order to pass.
    @Test
    public void testFindBookThatDoesntExist() throws BookNotFoundException {
        try {
            bc.findBook("Tiger");
            fail("BookNotFoundException was not thrown!");
        } catch (BookNotFoundException ex) {
            System.out.println("testFindBookThatDoesntExist test success");
        }
    }

}

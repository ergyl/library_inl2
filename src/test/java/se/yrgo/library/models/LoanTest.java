package se.yrgo.library.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import se.yrgo.library.utilities.GenderType;

import java.time.LocalDate;

public class LoanTest {

    //VG
    @Test
    public void testDueDate() {
        var customer = new Customer("Mr", "Bo", "Bokvist", "Gatan 1, Stenberga", "0751119111", "ok@mail.com", 123, GenderType.MALE);
        var book = new Book(1, "Abc", "", "", "", 0);
        var loan = new Loan(1, customer, book);

        var today = LocalDate.now();
        var inDueTime = LocalDate.now().plusDays(14);
        var overdue = LocalDate.now().plusDays(15);

        assertNotEquals(null, loan.getDueDate());

        assertTrue(today.isBefore(loan.getDueDate()) &&
                inDueTime.equals(loan.getDueDate()) &&
                overdue.isAfter(loan.getDueDate()));
    }
}
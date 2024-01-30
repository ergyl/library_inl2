package se.yrgo.library.models;


//import java.util.Date;
//import java.util.GregorianCalendar;

import java.time.LocalDate;
import utilities.LoanStatus;

/***
 * This class represents book loans from users.
 */

public class Loan {

private int ID;
private Customer customer;
private Book book;
//private Date startDate;
private LocalDate dueDate;
//private Date returnDate;
private LoanStatus status;
	
public Loan(int iD, Customer customer, Book book) {
  super();
  ID = iD;
  this.customer = customer;
  this.book = book;  
  dueDate = LocalDate.now().plusDays(14);
  status = LoanStatus.CURRENT;
}

@Override
public String toString() {
  return "Loan [ID=" + ID + ", customer=" + customer.getMailingName() + ", book=" + book.getTitle()
    + "]";
}

@Override
public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ID;
  return result;
}

@Override
public boolean equals(Object obj) {
  if (this == obj)
    return true;
  if (obj == null)
    return false;
  if (getClass() != obj.getClass())
    return false;
  Loan other = (Loan) obj;
  if (ID != other.ID)
    return false;
  return true;
}

public Customer getCustomer() {
  return customer;
}

public Book getBook() {
  return book;
}

  /***
   * This method is used for retrieving due date for book loans.
   * @return duedate for when the book is to be returned.
   */
  public LocalDate getDueDate() {
  return dueDate;
}

  /***
   * This method is used for checking loan status.
   * @return status
   */
  public LoanStatus getStatus() {
  return status;
}

  /***
   * This method is used to end a certain book loan.
   */
  public void endLoan() {
  //returnDate = new Date();
  status = LoanStatus.HISTORIC;
}
	
}

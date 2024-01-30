package se.yrgo.library.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import se.yrgo.library.models.Book;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		var b1 = new Book(1, "Title", "Jan Yan", "29229-2329932", "math", 300);
		var b2 = new Book(1, "Title", "Jan Yan", "29229-2329932", "math", 300);
		assertEquals(b1, b2, "Two identical books");
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		var b1 = new Book(1, "Title", "Jan Yan", "29229-2329932", "math", 300);
		var b2 = new Book(2, "Title", "Jan Yan", "29229-1829932", "math", 300);
		assertNotEquals(b1, b2, "Two non equal books");
	}

}

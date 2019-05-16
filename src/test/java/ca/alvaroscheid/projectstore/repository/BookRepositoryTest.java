/**
 * 
 */
package ca.alvaroscheid.projectstore.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import ca.alvaroscheid.projectstore.model.Book;

/**
 * @author alvaro-scheid
 *
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BookRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BookRepository bookRepository;

	private Book book1;
	private Book book2;

	@Before
	public void setUp() {
		book1 = new Book(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10),
				RandomStringUtils.randomAlphabetic(10));
		book2 = new Book(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10),
				RandomStringUtils.randomAlphabetic(10));
		entityManager.persistAndFlush(book1);
		entityManager.persistAndFlush(book2);
	}

	@Test
	public void testFindAll() {
		List<Book> books = bookRepository.findAll();
		assertEquals(books.size(), 2);
	}

	@Test
	public void testFindById() {
		Optional<Book> book = bookRepository.findById(book1.getId());
		assertEquals(book.get().getBookName(), book1.getBookName());
	}
}

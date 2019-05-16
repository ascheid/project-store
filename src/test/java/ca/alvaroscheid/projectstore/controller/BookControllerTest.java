/**
 * 
 */
package ca.alvaroscheid.projectstore.controller;

import static java.util.Collections.singletonList;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import ca.alvaroscheid.projectstore.exception.BookNotFoundException;
import ca.alvaroscheid.projectstore.model.Book;

/**
 * @author alvaro-scheid
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

	private Book book;

	@Autowired
	private MockMvc mvc;

	@MockBean
	private BookController bookController;

	@Before
	public void setUp() {
		book = new Book(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10),
				RandomStringUtils.randomAlphabetic(10));
	}

	@Test
	public void getBooks() throws Exception {
		List<Book> allBooks = singletonList(book);

		given(bookController.getAllBooks()).willReturn(allBooks);

		mvc.perform(get("/books").contentType(APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].bookName", is(book.getBookName())));
	}

	@Test
	public void getBooksById() throws Exception {
		book.setId(1L);
		given(bookController.getBookById(book.getId())).willReturn(book);
		mvc.perform(get("/books/" + book.getId()).contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("bookName", is(book.getBookName())));
	}

}

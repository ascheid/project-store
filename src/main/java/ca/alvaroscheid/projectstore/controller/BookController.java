/**
 * 
 */
package ca.alvaroscheid.projectstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.alvaroscheid.projectstore.exception.BookNotFoundException;
import ca.alvaroscheid.projectstore.model.Book;
import ca.alvaroscheid.projectstore.repository.BookRepository;

/**
 * @author alvaro-scheid
 *
 */

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@PostMapping("/books")
	public Book createBook(@Valid @RequestBody Book book) {
		return bookRepository.save(book);
	}

	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
		return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
	}

	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable(value = "id") Long bookId, @Valid @RequestBody Book bookDetails)
			throws BookNotFoundException {
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
		book.setBookName(bookDetails.getBookName());
		book.setAuthorName(bookDetails.getAuthorName());
		book.setIsbn(bookDetails.getIsbn());
		Book updatedBook = bookRepository.save(book);
		return updatedBook;
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
		bookRepository.delete(book);
		return ResponseEntity.ok().build();
	}
}

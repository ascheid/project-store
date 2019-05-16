/**
 * 
 */
package ca.alvaroscheid.projectstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author alvaro-scheid
 *
 */

@Entity
@Table
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String bookName;
	@NotBlank
	private String authorName;
	@NotBlank
	private String isbn;

	public Book() {
		super();
	}

	public Book(Long id, String bookName, String authorName, String isbn) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.isbn = isbn;
	}

	public Book(String bookName, String authorName, String isbn) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.isbn = isbn;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}

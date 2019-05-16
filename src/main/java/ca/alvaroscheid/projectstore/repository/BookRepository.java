/**
 * 
 */
package ca.alvaroscheid.projectstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.alvaroscheid.projectstore.model.Book;

/**
 * @author alvaro-scheid
 *
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

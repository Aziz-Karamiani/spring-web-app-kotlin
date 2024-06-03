package ir.tapture.spring6webapp.repositories

import ir.tapture.spring6webapp.domain.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, Long> {
}
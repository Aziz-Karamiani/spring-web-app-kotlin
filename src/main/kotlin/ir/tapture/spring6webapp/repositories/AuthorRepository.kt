package ir.tapture.spring6webapp.repositories

import ir.tapture.spring6webapp.domain.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : CrudRepository<Author, Long> {
}
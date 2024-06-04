package ir.tapture.spring6webapp.repositories

import ir.tapture.spring6webapp.domain.Publisher
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PublisherRepository : CrudRepository<Publisher, Long> {
}
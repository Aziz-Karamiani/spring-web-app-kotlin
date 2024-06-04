package ir.tapture.spring6webapp.bootstrap

import ir.tapture.spring6webapp.domain.Author
import ir.tapture.spring6webapp.domain.Book
import ir.tapture.spring6webapp.domain.Publisher
import ir.tapture.spring6webapp.repositories.AuthorRepository
import ir.tapture.spring6webapp.repositories.BookRepository
import ir.tapture.spring6webapp.repositories.PublisherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootstrapData(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository,
    private val publisherRepository: PublisherRepository
) :
    CommandLineRunner {

    override fun run(vararg args: String?) {
        val publisher = Publisher(
            publisherName = "My Publisher",
            address = "address",
            city = "city",
            state = "state",
            zipCode = "123"
        )

        val publisherSaved = publisherRepository.save(publisher)

        val eric = Author(firstName = "Eric", lastName = "Evans")
        val ddd = Book(title = "Domain Driven Design", isbn = "123456")
        val ericSaved = authorRepository.save(eric)
        val dddSaved = bookRepository.save(ddd)

        val rod = Author(firstName = "Rod", lastName = "Johnson")
        val noEJB = Book(title = "J2EE Development without EJB", isbn = "569874")
        val rodSaved = authorRepository.save(rod)
        val noEJBSaved = bookRepository.save(noEJB)

        dddSaved.publisher = publisherSaved
        noEJBSaved.publisher = publisherSaved

        ericSaved.books.add(dddSaved);
        rodSaved.books.add(noEJBSaved);
        dddSaved.authors.add(ericSaved)
        noEJBSaved.authors.add(rodSaved)

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved)
        bookRepository.save(noEJBSaved)

        println("In Bootstrap");
        println("Publisher Count: " + publisherRepository.count());
        println("Author Count: " + authorRepository.count());
        println("Book Count: " + bookRepository.count());
    }
}
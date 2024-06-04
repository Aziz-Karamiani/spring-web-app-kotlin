package ir.tapture.spring6webapp.bootstrap

import ir.tapture.spring6webapp.domain.Author
import ir.tapture.spring6webapp.domain.Book
import ir.tapture.spring6webapp.repositories.AuthorRepository
import ir.tapture.spring6webapp.repositories.BookRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootstrapData(private val authorRepository: AuthorRepository, private val bookRepository: BookRepository) :
    CommandLineRunner {

    override fun run(vararg args: String?) {
        val eric = Author(firstName = "Eric", lastName = "Evans")
        val ddd = Book(title = "Domain Driven Design", isbn = "123456")
        val ericSaved = authorRepository.save(eric)
        val dddSaved = bookRepository.save(ddd)

        val rod = Author(firstName = "Rod", lastName = "Johnson")
        val noEJB = Book(title = "J2EE Development without EJB", isbn = "569874")
        val rodSaved = authorRepository.save(rod)
        val noEJBSaved = bookRepository.save(noEJB)

        ericSaved.books.add(dddSaved);
        rodSaved.books.add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        println("In Bootstrap");
        println("Author Count: " + authorRepository.count());
        println("Book Count: " + bookRepository.count());
    }
}
package ir.tapture.spring6webapp.services

import ir.tapture.spring6webapp.domain.Book
import ir.tapture.spring6webapp.repositories.BookRepository

class BookServiceImpl(private val bookRepository: BookRepository) : BookService {
    override fun findAll(): Iterable<Book> {
        return bookRepository.findAll()
    }
}
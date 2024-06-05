package ir.tapture.spring6webapp.services

import ir.tapture.spring6webapp.domain.Book

interface BookService {
    fun findAll(): Iterable<Book>
}
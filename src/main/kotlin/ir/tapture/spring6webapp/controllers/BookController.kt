package ir.tapture.spring6webapp.controllers

import ir.tapture.spring6webapp.services.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BookController(private val bookService: BookService) {
    @RequestMapping("/books")
    fun getBooks(model: Model): String {
        model.addAttribute("books", bookService.findAll())

        return "books"
    }
}
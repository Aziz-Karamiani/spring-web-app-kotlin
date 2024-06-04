package ir.tapture.spring6webapp.domain

import jakarta.persistence.*

@Entity
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    @ManyToMany(mappedBy = "authors")
    val books: MutableList<Book> = mutableListOf()
)
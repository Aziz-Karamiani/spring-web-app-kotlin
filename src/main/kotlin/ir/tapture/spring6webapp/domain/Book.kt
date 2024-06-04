package ir.tapture.spring6webapp.domain

import jakarta.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String,
    val isbn: String,
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "author_book",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    val authors: MutableList<Author> = mutableListOf()
)
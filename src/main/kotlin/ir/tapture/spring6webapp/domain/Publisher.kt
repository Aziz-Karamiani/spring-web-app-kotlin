package ir.tapture.spring6webapp.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Publisher(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    val id: Long = 0,
    val publisherName: String,
    val address: String,
    val city: String,
    val state: String,
    val zipCode: String,
    @OneToMany(mappedBy = "publisher")
    val books: MutableList<Book> = mutableListOf()
)

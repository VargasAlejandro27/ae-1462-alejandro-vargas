package com.pucetec.ae1473exam1.services

import com.pucetec.ae1473exam1.dto.BookRequest
import com.pucetec.ae1473exam1.dto.BookResponse
import com.pucetec.ae1473exam1.entities.Book
import com.pucetec.ae1473exam1.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    private fun normalizeText(value: String): String {
        val words = value.trim().split(" ").filter { it.isNotBlank() }
        val capitalizedWords = words.map { word ->
            val first = word.firstOrNull()?.uppercase() ?: ""
            val rest = if (word.length > 1) word.substring(1).lowercase() else ""
            first + rest
        }
        return capitalizedWords.joinToString(" ")
    }

    private fun buildSlug(title: String): String {
        return title.lowercase().replace(" ", "-")
    }

    private fun toBookResponse(book: Book): BookResponse {
        val finalPrice = book.priceUsd * 1.12
        return BookResponse(
            id = book.id!!,
            title = book.title,
            author = book.author,
            slug = buildSlug(book.title),
            priceUsd = book.priceUsd,
            finalPrice = finalPrice
        )
    }

    fun create(request: BookRequest): BookResponse {
        val entity = Book(
            title = normalizeText(request.title),
            author = normalizeText(request.author),
            priceUsd = request.priceUsd
        )
        val savedBook = bookRepository.save(entity)
        return toBookResponse(savedBook)
    }

    fun listAll(): List<BookResponse> {
        val books = bookRepository.findAll()
        val responses = books.map { book -> toBookResponse(book) }
        return responses.sortedBy { response -> response.title }
    }
}

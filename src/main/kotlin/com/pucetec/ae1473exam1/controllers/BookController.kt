package com.pucetec.ae1473exam1.controllers

import com.pucetec.ae1473exam1.dto.BookRequest
import com.pucetec.ae1473exam1.dto.BookResponse
import com.pucetec.ae1473exam1.services.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController(private val bookService: BookService) {

    @PostMapping
    fun create(@RequestBody request: BookRequest): BookResponse = bookService.create(request)

    @GetMapping
    fun listAll(): List<BookResponse> = bookService.listAll()
}

package com.nt.controller;


import com.nt.dto.BookDto;
import com.nt.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/saveBook")
    public ResponseEntity<BookDto> registerBook(@RequestBody BookDto bookDto){
        BookDto savedBook = bookService.saveBook(bookDto);
        return new ResponseEntity<BookDto>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/updateBook")
    public ResponseEntity<BookDto> updateBook(@PathVariable UUID id, @RequestBody BookDto bookDto){
        BookDto updatedBook = bookService.updateBook(id,bookDto);
        return new ResponseEntity<BookDto>(updatedBook, HttpStatus.OK);
    }

    @GetMapping("/{id}/book")
    public ResponseEntity<BookDto> getBook(@PathVariable UUID id){
        BookDto book = bookService.getBook(id);
        return new ResponseEntity<BookDto>(book, HttpStatus.OK);
    }

    @GetMapping("allBook")
    public ResponseEntity<List<BookDto>> getAllBook(){
        List<BookDto> allBook = bookService.getAllBook();
        return new ResponseEntity< List<BookDto> >(allBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/book")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id){
        String message = bookService.deleteBook(id);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }



}


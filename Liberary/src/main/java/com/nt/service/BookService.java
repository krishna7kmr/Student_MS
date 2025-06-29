package com.nt.service;



import com.nt.dto.BookDto;

import java.util.List;
import java.util.UUID;

public interface BookService {

    BookDto saveBook(BookDto bookDto);
    BookDto updateBook(UUID id, BookDto bookDto);
    BookDto getBook(UUID id);
    List<BookDto> getAllBook();
    String deleteBook(UUID id);
}

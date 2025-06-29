package com.nt.util;

import com.nt.dto.BookDto;
import com.nt.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    // Convert from source object to target class
    public static <D> D convert(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    // Example of mapping Book entity to BookDTO (assuming BookDTO exists)
    public static BookDto convertToBookDTO(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    // Example of mapping BookDTO to Book entity
    public static Book convertToBook(BookDto bookDTO, Class<Book> bookClass) {
        return modelMapper.map(bookDTO, Book.class);
    }
}

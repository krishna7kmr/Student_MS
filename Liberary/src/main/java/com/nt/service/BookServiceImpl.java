package com.nt.service;

import com.nt.dto.BookDto;
import com.nt.entity.Book;
import com.nt.repository.BookRepository;
import com.nt.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public  class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ModelMapperUtil modelMapperUtil;



    @Override
    public BookDto saveBook(BookDto bookDto) {
        Book book = ModelMapperUtil.convert(bookDto, Book.class);
        book.setId(UUID.randomUUID());
        Book  savedBook = bookRepository.save(book);
        return ModelMapperUtil.convert(savedBook, BookDto.class);

    }

    @Override
    public BookDto updateBook(UUID id, BookDto bookDto) {
        Optional<Book> op = bookRepository.findById(id);
        if(op.isPresent()){
            Book book = op.get();

            book.setName(bookDto.getName());
            book.setRentCost(bookDto.getRentCost());
            book.setNoOfDays(bookDto.getNoOfDays());
            Book updatedBook = bookRepository.save(book);
            return ModelMapperUtil.convert(updatedBook,BookDto.class);
        }
     else {
   return null;
}
    }

    @Override
    public BookDto getBook(UUID id) {
        return null;
    }

    @Override
    public List<BookDto> getAllBook() {
        return List.of();
    }

    @Override
    public String deleteBook(UUID id) {
        return "";
    }
}

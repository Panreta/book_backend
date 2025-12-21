package com.book.api.config;

import com.book.api.entities.Book;
import com.book.api.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            System.out.println("Initializing books...");

            // Add 4 more books (you already have 1)
            repository.save(createBook(
                    9780987654321L,
                    "Introduction to Algorithms",
                    "Thomas Cormen",
                    "Comprehensive algorithms textbook",
                    "Computer Science",
                    50.25
            ));

            repository.save(createBook(
                    7384937204833L,
                    "Head First Design Patterns",
                    "Bert Bates, Kathy Sierra",
                    "Design patterns made easy",
                    "Programming",
                    17.25
            ));

            repository.save(createBook(
                    8309654321L,
                    "Clean Code",
                    "Robert C. Martin",
                    "A Handbook of Agile Software Craftsmanship",
                    "Programming",
                    32.50
            ));

            repository.save(createBook(
                    9876543210L,
                    "Wings of Fire",
                    "Dr. APJ Abdul Kalam",
                    "Autobiography",
                    "Biography",
                    18.00
            ));

            System.out.println("Books initialized!");
        };
    }

    private Book createBook(Long isbn, String title, String author,
                            String description, String category, double price) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);
        book.setCategory(category);
        book.setPrice(price);
        book.setQuantity(10);
        return book;
    }
}
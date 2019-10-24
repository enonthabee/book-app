package com.bookapp.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *
 * @author lindisizwemakaula
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {
    @Id
    private String isbn;
    private String title;
    private boolean isAvailable = true;
    private String category;
    private LocalDate returnDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_author")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}

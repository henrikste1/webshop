package no.henrikste1.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long categoryId; // Primary key

    private String name;

    private String description;

    /*
    private String userId; // Foreign key

    private Long productId; // Foreign key
    **/

    // Getters and setters

}

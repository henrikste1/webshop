package no.henrikste1.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Long productId; // Primary Key

    private String name;

    private String price;

    private String picture;

    private String description;

    /*
    private String userId; // Foreign key

    private Long categoryId; // Foreign key
    **/

    // Getters and setters

}

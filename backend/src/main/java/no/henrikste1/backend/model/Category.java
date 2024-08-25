package no.henrikste1.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany
    @JoinColumn
    private Product product;

    @ManyToOne
    @JoinColumn
    private User user;

    // Getters and setters

}

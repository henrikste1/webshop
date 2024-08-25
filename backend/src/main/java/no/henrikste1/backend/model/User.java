package no.henrikste1.backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Integer permissionLevel = 1;

    @OneToMany
    @JoinColumn
    private Product product;

    @OneToMany
    @JoinColumn
    private Category category;

    /*
    private String firebaseUserId;
    **/
}

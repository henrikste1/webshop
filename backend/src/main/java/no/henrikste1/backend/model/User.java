package no.henrikste1.backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Long userId;

    /*
    private String userId;
    private Integer permissionLevel;
    **/
}

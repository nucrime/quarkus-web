package by.ak.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends PanacheEntity {
    @Column(length = 40, unique = true)
    private String name;
    private String email;
}

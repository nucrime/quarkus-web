package by.ak.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class User extends PanacheEntity {
    private String name;
    private String email;
}

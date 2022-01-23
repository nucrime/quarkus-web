package by.ak.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * User entity
 * Uses PanacheEntity to implement reactive queries
 * Uses Cacheable to cache entity
 *
 * @see io.quarkus.hibernate.reactive.panache.PanacheEntity
 * @see <a href="https://quarkus.io/guides/hibernate-reactive-panache">Quarkus Hibernate Reactive Panache</a>
 * @see javax.persistence.Cacheable
 * @author Aliaksandr Karankevich
 */
@Entity
public class User extends PanacheEntity {
    @Column(length = 40, unique = true)
    private String name;
    private String email;
}

package by.ak.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * <b>User entity</b>
 * <p>
 * Uses PanacheEntity to implement reactive queries.
 * Uses Cacheable to cache entity
 * </p>
 *
 * <pre>
 * {@link User#id} (Long). Comes from PanacheEntity
 * {@link User#name} (String) - item name. Unique. Max length: 40.
 * {@link User#email} (String) - item description
 * </pre>
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

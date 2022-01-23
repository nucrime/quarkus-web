package by.ak.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * <p>
 * Item entity.
 * Uses PanacheEntity to implement reactive queries.
 * Uses Cacheable to cache entity.
 * </p>
 *
 * <pre>
 * {@link Item#id} (Long). Comes from PanacheEntity
 * {@link Item#name} (String) - item name. Unique. Max length: 40.
 * {@link Item#description} (String) - item description
 * {@link Item#image} (String) - item image
 * {@link Item#price} (String) - item price
 * {@link Item#category} (String) - item category
 * </pre>
 *
 * @see io.quarkus.hibernate.reactive.panache.PanacheEntity
 * @see <a href="https://quarkus.io/guides/hibernate-reactive-panache">Quarkus Hibernate Reactive Panache</a>
 * @see javax.persistence.Cacheable
 * @author Aliaksandr Karankevich
 */
@Entity
@Cacheable
public class Item extends PanacheEntity {
    @Column(length = 40, unique = true)
    private String name;
    private String description;
    private String image;
    private String price;
    private String category;
}

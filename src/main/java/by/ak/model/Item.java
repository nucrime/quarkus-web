package by.ak.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

@Entity
@Cacheable
public class Item extends PanacheEntity {
    private String name;
    private String description;
    private String image;
    private String price;
    private String category;
}

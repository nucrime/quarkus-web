package by.ak.service;

import by.ak.model.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ItemService {
    @Inject
    EntityManager em;

    public void createItem(Item item) {
        em.persist(item);
    }

    public void updateItem(Item item) {
        em.merge(item);
    }

    public void deleteItem(Item item) {
        em.remove(item);
    }

    public Item getItem(Long id) {
        return em.find(Item.class, id);
    }

    public Item getItemByName(String name) {
        return em.createNamedQuery("Item.findByName", Item.class).setParameter("name", name).getSingleResult();
    }

    public Item getItemByDescription(String description) {
        return em.createNamedQuery("Item.findByDescription", Item.class).setParameter("description", description).getSingleResult();
    }

    public Item getItemByPrice(Double price) {
        return em.createNamedQuery("Item.findByPrice", Item.class).setParameter("price", price).getSingleResult();
    }

    public Item getItemByQuantity(Integer quantity) {
        return em.createNamedQuery("Item.findByQuantity", Item.class).setParameter("quantity", quantity).getSingleResult();
    }
}

package webshop.model;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private int id;
    private ShoppingCart shoppingCart;
    private Collection<Order> orders;
    private CustomerContact contact;

    public Customer(int id, CustomerContact cc) {
        this.id = id;
        this.contact = cc;
    }

    public static Customer createNewWithId(CustomerContact cc) {
        int nextId = 0; //create id, what was unused before TODO
        return new Customer(nextId, cc);
    }

    public void addOrder(Order o) {
    } //add order to collection of orders

    public void deleteShoppingCart() {
    } //delete the element from shopping cart, because they are an order now
}

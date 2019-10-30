package webshop.model;

import java.util.Collection;

public class Customer {
    private int id;
    private ShoppingCart shoppingCart;
    private Collection<Order> orders;
    private CustomerContact contact;
}

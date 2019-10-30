package webshop.model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private LocalDateTime orderDateTime;
    private ShoppingCart shoppingCart;
    private Customer customer;
    private Delivery delivery;
    private OrderStatus status;
    private PaymentMethod paymentMethod;

}

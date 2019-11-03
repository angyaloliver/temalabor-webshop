package webshop.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int id;
    private LocalDateTime orderDateTime;
    private ShoppingCart shoppingCart;
    private Customer customer;
    private Delivery delivery;
    private OrderStatus status;
    private PaymentMethod paymentMethod;

    public Order(int id, LocalDateTime orderDateTime, ShoppingCart shoppingCart, Customer customer, Delivery delivery,
                 OrderStatus status, PaymentMethod paymentMethod) {
        this.id = id;
        this.orderDateTime = orderDateTime;
        this.shoppingCart = shoppingCart;
        this.customer = customer;
        this.delivery = delivery;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public static Order createNewOrder(ShoppingCart shoppingCart, Customer customer, Delivery delivery,
                                       PaymentMethod paymentMethod) {
        int nextId = 0; //create random id, what was unused before TODO
        OrderStatus orderStatus = OrderStatus.Processing;
        LocalDateTime localDateTime = LocalDateTime.now();
        return new Order(nextId, localDateTime, shoppingCart, customer, delivery, orderStatus, paymentMethod);
    }

}

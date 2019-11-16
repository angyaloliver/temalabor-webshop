package webshop.model;

import java.util.Collection;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {

  @Id
  @GeneratedValue
  private Integer id;

  @OneToOne
  private ShoppingCart shoppingCart;

  @OneToMany(mappedBy = "customer")
  private Collection<OrderDetails> orderDetails;

  @OneToOne
  private CustomerContact contact;

  public Customer() {

  }

  public Customer(CustomerContact cc) {
    this.contact = cc;
  }

  public void addOrder(OrderDetails o) {
  }

  public void deleteShoppingCart() {
  }
}

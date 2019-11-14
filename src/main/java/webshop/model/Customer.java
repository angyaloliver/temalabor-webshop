package webshop.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

  @OneToMany
  private Collection<Order> orders;

  @OneToOne
  private CustomerContact contact;

  public Customer() {

  }

  public Customer(CustomerContact cc) {
    this.contact = cc;
  }

  public void addOrder(Order o) {
  }

  public void deleteShoppingCart() {
  }
}

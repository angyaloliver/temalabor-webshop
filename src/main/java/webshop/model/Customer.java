package webshop.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
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

  @OneToOne(cascade = {CascadeType.ALL})
  private ShoppingCart shoppingCart = new ShoppingCart();

  @OneToMany(mappedBy = "customer")
  private Collection<OrderDetails> orderDetails = new ArrayList<>();

  @OneToOne(cascade = {CascadeType.ALL})
  private CustomerContact contact;

  public Customer() {
  }

  public Customer(CustomerContact cc) {
    this.contact = cc;
  }

  public void addOrder(OrderDetails o) {
    orderDetails.add(o);
  }

  public int numberOfOrders(){
    return orderDetails.size();
  }
}

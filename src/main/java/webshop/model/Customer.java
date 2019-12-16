package webshop.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
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

  public int numberOfOrders() {
    return orderDetails.size();
  }

}

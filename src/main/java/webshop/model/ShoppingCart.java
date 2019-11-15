package webshop.model;

import java.util.Collection;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShoppingCart {

  @Id
  @GeneratedValue
  private Integer id;

  @OneToOne
  private Customer customer;

  @OneToMany
  private Collection<Product> products;

  @OneToOne
  private OrderDetails orderDetails;

  public void addProduct(Product p) {

  }
}

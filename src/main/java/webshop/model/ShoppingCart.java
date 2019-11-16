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

  @OneToMany
  private Collection<Product> products;

  public void addProduct(Product p) {

  }
}

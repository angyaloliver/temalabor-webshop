package webshop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    products = new ArrayList<>(Collections.singleton(p));
  }
}

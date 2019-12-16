package webshop.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShoppingCart {

  @Id
  @GeneratedValue
  private Integer id;

  @ManyToMany(cascade = CascadeType.ALL)
  private Collection<Product> products = new ArrayList<>();

  public void addProduct(Product p) {
    products.add(p);
  }

  public void removeProduct(Product productToRemove) {
    products.removeIf(product -> product.getId().equals(productToRemove.getId()));
  }
}

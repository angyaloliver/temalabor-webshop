package webshop.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@Entity
public class ProductCategory {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  @OneToMany(mappedBy = "productCategory")
  private Collection<Product> products = new HashSet<>();

  public ProductCategory() {
  }

  public ProductCategory(String name) {
    super();
    this.name = name;
  }

  public void addProduct(Product product) {
    product.addProductCategory(this);
    this.products.add(product);
  }
}

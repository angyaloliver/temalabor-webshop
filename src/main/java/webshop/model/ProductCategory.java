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

@Getter
@Setter
@Entity
public class ProductCategory {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  @OneToMany(mappedBy = "productCategory")
  private Collection<Product> products;

  public ProductCategory() {
  }

  public ProductCategory(String name) {
    super();
    this.name = name;
    this.products = new HashSet<>();
  }


  public ProductCategory(Integer id, String name) {
    super();
    this.id = id;
    this.name = name;
    this.products = new HashSet<>();
  }

  public void addProduct(Product product) {
    product.addProductCategory(this);
    this.products.add(product);
  }
}

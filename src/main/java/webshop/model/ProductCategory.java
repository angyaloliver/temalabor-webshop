package webshop.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
@Builder
@AllArgsConstructor
public class ProductCategory {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  @ManyToMany(mappedBy = "productCategories")
  @Default
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

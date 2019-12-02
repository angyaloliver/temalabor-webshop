package webshop.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.*;
import lombok.Builder.Default;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class Product {

  @Id
  @GeneratedValue
  private Integer id;

  @NonNull
  private String name;

  private int numberInStock;
  private String description;

  @OneToOne(cascade = {CascadeType.ALL})
  private Price originalPrice;

  @Setter(AccessLevel.NONE)
  @OneToOne
  private Price reducedPrice;

  private BigDecimal discountRate;

  @OneToMany(cascade=CascadeType.ALL)
  @Default
  private Collection<ProductImage> images = new HashSet<>();

  @ManyToMany(cascade=CascadeType.ALL)
  @JoinTable(
      name = "product_categories"
  )
  @Default
  private Collection<ProductCategory> productCategories = new HashSet<>();

  public Product() {
  }

  public void discount(BigDecimal discountRate) {
    this.discountRate = discountRate;
    if (reducedPrice == null) {
      reducedPrice = new Price();
    }
    reducedPrice.setNet(originalPrice.getNet().multiply(discountRate));
    reducedPrice.setGross(originalPrice.getGross().multiply(discountRate));
  }

  public void addProductCategory(ProductCategory productCategory) {
    productCategories.add(productCategory);
  }

}

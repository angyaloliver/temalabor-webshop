package webshop.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class Product {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;
  private int numberInStock;
  private String description;

  @OneToOne(cascade = {CascadeType.ALL})
  private Price originalPrice;

  @Setter(AccessLevel.NONE)
  @OneToOne
  private Price reducedPrice;

  private BigDecimal discountRate;

  @OneToMany
  private Collection<ProductImage> images;

  @OneToMany
  private Collection<ProductCategory> productCategories;

  public Product() {
  }

  public Product(Integer id, String name, Price originalPrice) {
    this.id = id;
    this.name = name;
    this.originalPrice = originalPrice;
    this.reducedPrice = originalPrice;
    this.productCategories = new HashSet<>();
  }

  public Product(Integer id, String name, int numberInStock, String description,
      Price originalPrice) {
    super();
    this.id = id;
    this.name = name;
    this.numberInStock = numberInStock;
    this.description = description;
    this.originalPrice = originalPrice;
    this.reducedPrice = originalPrice;
    this.discountRate = BigDecimal.valueOf(1.0);
    this.productCategories = new HashSet<>();
  }

  public void discount(BigDecimal discountRate) {
    this.discountRate = discountRate;
    reducedPrice.setNet(originalPrice.getNet().multiply(discountRate));
    reducedPrice.setGross(originalPrice.getGross().multiply(discountRate));
  }

  public void addProductCategory(ProductCategory productCategory) {
    productCategories.add(productCategory);
  }

}

package webshop.model;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product { //TODO apply Builder pattern

  @Id
  @GeneratedValue
  private Integer id;

  private String name;
  private int numberInStock;
  private String description;

  @OneToOne(cascade = {CascadeType.ALL}) //quick Stackoverflow fix, don't know what it does, but makes DiscountServiceIT pass
  private Price originalPrice;

  @Setter(AccessLevel.NONE)
  @OneToOne
  private Price reducedPrice;

  private BigDecimal discountRate;

  @OneToMany
  private Collection<ProductImage> images;

  @ManyToOne
  private ProductCategory productCategory; //for testing purposes

  @OneToMany
  private Collection<ProductCategory> categories;

  public Product() {
  }

  public Product(Integer id, String name, Price originalPrice) {
    this.id = id;
    this.name = name;
    this.originalPrice = originalPrice;
    this.reducedPrice = originalPrice;
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
  }

  public void discount(BigDecimal discountRate) {
    this.discountRate = discountRate;
    reducedPrice.setNet(originalPrice.getNet().multiply(discountRate));
    reducedPrice.setGross(originalPrice.getGross().multiply(discountRate));
  }

}

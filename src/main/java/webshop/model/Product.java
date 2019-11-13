package webshop.model;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private int numberInStock;
  private String description;
  private Price originalPrice;

  @Setter(AccessLevel.NONE)
  private Price reducedPrice;
  private BigDecimal discountRate;
  private Collection<ProductImage> images;
  private Collection<ProductCategory> categories;

  public Product(String name, int number, String description, Price originalPrice) {
    this.name = name;
    this.numberInStock = number;
    this.description = description;
    this.originalPrice = originalPrice;
    this.reducedPrice = originalPrice;
    this.discountRate = BigDecimal.valueOf(1.0);
  }

  public void discount(){
    reducedPrice.setNet(originalPrice.getNet().multiply(discountRate));
    reducedPrice.setGross(originalPrice.getGross().multiply(discountRate));
  }

}

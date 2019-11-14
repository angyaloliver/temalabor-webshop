package webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductImage {

  @Id
  @GeneratedValue
  private Integer id;

  private String url;
  private String altText;
}

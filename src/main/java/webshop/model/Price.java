package webshop.model;

import java.math.BigDecimal;
import java.util.Currency;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Price {

  @Id
  @GeneratedValue
  private Integer id;

  private BigDecimal net;
  private BigDecimal gross;
  private BigDecimal tax;
  private Currency currency;

  public Price() {

  }

  public Price(BigDecimal net, BigDecimal tax) {
    this.net = net;
    this.tax = tax;
    this.gross = net.multiply(tax);
  }

}

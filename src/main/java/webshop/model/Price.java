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
  private BigDecimal taxRate;
  private Currency currency;

  public Price() {

  }

  public Price(BigDecimal net, BigDecimal taxRate) {
    this.net = net;
    this.taxRate = taxRate;
    this.gross = net.multiply(BigDecimal.ONE.add(taxRate));
  }


}

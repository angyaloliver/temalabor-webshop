package webshop.model;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CustomerContact {

  @Id
  @GeneratedValue
  private Integer id;
  private String emailAddress;

  @OneToMany
  private Collection<Address> billingAddresses;

  @OneToOne
  private CustomerName name;
  private String phoneNumber;

  private LocalDateTime registrationDateTime;

}

package webshop.model;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class CustomerContact {


  @Id
  @GeneratedValue
  private Integer id;
  @NonNull
  private String emailAddress;

  @OneToMany(cascade = {CascadeType.ALL})
  private Collection<Address> billingAddresses;

  @OneToOne(cascade = {CascadeType.ALL})
  private CustomerName name;

  private String phoneNumber;

  private LocalDateTime registrationDateTime;

  public CustomerContact() {
  }
}

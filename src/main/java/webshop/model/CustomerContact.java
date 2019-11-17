package webshop.model;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

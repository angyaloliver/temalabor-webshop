package webshop.model;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

  @NonNull
  private String password;
  @NonNull
  private String username;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "customer_roles", joinColumns = @JoinColumn(name = "customer_contact_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Collection<Role> roles;

  @OneToMany(cascade = {CascadeType.ALL})
  private Collection<Address> billingAddresses;

  @OneToOne(cascade = {CascadeType.ALL})
  private CustomerName name;

  private String phoneNumber;

  private LocalDateTime registrationDateTime;

  public CustomerContact() {
  }
}

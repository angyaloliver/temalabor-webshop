package webshop.model;

import java.time.LocalDateTime;
import java.util.Collection;

public class CustomerContact {

  private String emailAddress;
  private Collection<Address> billingAddresses;
  private CustomerName name;
  private String phoneNumber;
  private LocalDateTime registrationDateTime;

}

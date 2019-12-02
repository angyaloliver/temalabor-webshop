package webshop.model;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.*;

import lombok.*;

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

package webshop.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class Role {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  @ManyToMany(mappedBy = "roles")
  private Collection<CustomerContact> customerContacts;

  public Role() {
    super();
  }

  public Role(final String name) {
    super();
    this.name = name;
  }
}

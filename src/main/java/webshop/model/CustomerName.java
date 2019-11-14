package webshop.model;

import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CustomerName {

  @Id
  @GeneratedValue
  private Integer id;
  private String firstName;
  private String lastName;

  @ElementCollection(targetClass = Prefix.class)
  private Collection<Prefix> prefixes;
}

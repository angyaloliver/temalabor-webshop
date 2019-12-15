package webshop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webshop.model.Customer;
import webshop.model.Role;

@Service
public class Assembler {

  private Collection<? extends GrantedAuthority> getAuthorities(
      final Collection<Role> roles) {
    return getGrantedAuthorities(roles);
  }

  private List<GrantedAuthority> getGrantedAuthorities(Collection<Role> roles) {
    final List<GrantedAuthority> authorities = new ArrayList<>();
    for (final Role role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    }
    return authorities;
  }

  @Transactional(readOnly = true)
  User buildUserFromCustomer(Customer customer) {
    String username = customer.getContact().getUsername();
    String password = customer.getContact().getPassword();

    return new User(username, password, getAuthorities(customer.getContact().getRoles()));
  }
}

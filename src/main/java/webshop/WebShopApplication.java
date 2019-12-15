package webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webshop.model.Address;
import webshop.model.Customer;
import webshop.model.CustomerContact;
import webshop.model.CustomerName;
import webshop.model.Delivery;
import webshop.model.DeliveryMethod;
import webshop.model.OrderDetails;
import webshop.model.PaymentMethod;
import webshop.model.Price;
import webshop.model.Product;
import webshop.model.ProductCategory;
import webshop.model.ProductImage;
import webshop.model.ShoppingCart;
import webshop.repository.CustomerRepository;
import webshop.repository.OrderRepository;
import webshop.repository.ProductCategoryRepository;
import webshop.repository.ProductRepository;
import webshop.repository.RoleRepository;
import webshop.repository.ShoppingCartRepository;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

  @Autowired
  ProductCategoryRepository productCategoryRepository;
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  ShoppingCartRepository shoppingCartRepository;
  @Autowired
  RoleRepository roleRepository;


  public static void main(String[] args) {
    SpringApplication.run(WebShopApplication.class, args);
  }

  @Override
  public void run(String... args) {
    /*
    CustomerName customerName = new CustomerName("Root", "Root");
    LocalDateTime time = LocalDateTime.now();

    Address address = new Address("Hungary", "1111", "Budapest", "Váci street 6.");

    List<Address> addressList = new LinkedList<>();
    addressList.add(address);

    //Role role = new Role("ROLE_ADMIN");
    //roleRepository.save(role);

    CustomerContact customerContact = CustomerContact.builder()
        .name(customerName)
        .username("root")
        .password("root")
        .emailAddress("email@address.com")
        .billingAddresses(addressList)
        .phoneNumber("+36301111111")
        .registrationDateTime(time)
        .roles(Arrays.asList(roleRepository.findByName("ROLE_ADMIN")))
        .build();

    Customer customer = Customer.builder()
        .contact(customerContact)
        .build();

    customerRepository.save(customer);
    */
  }

}

package webshop;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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


  public static void main(String[] args) {
    SpringApplication.run(WebShopApplication.class, args);
  }

  @Override
  public void run(String... args) {
    CustomerName customerName = new CustomerName("John", "Doe");
    LocalDateTime time = LocalDateTime.now();

    Address address = new Address("Hungary", "1111", "Budapest", "Váci street 6.");

    List<Address> addressList = new LinkedList<>();
    addressList.add(address);

    ProductImage image = new ProductImage("https://pcbonlineshop.com/photos/product/4/176/4.jpg",
        "beats");
    ArrayList<ProductImage> images = new ArrayList<>();
    images.add(image);

    ProductCategory category = ProductCategory.builder()
        .name("category example")
        .build();

    ArrayList<ProductCategory> categories = new ArrayList<>();
    categories.add(category);

    Product product = Product.builder()
        .name("product")
        .originalPrice(new Price(BigDecimal.valueOf(100), BigDecimal.valueOf(27)))
        .description("this is a product")
        .numberInStock(2)
        .images(images)
        .build();

    product.addProductCategory(category);

    productRepository.save(product);

    category.addProduct(product);

    productCategoryRepository.save(category);

    ShoppingCart shoppingCart = new ShoppingCart();

    shoppingCartRepository.save(shoppingCart);

    CustomerContact customerContact = CustomerContact.builder()
        .name(customerName)
        .emailAddress("email@address.com")
        .billingAddresses(addressList)
        .phoneNumber("+36301111111")
        .registrationDateTime(time)
        .build();

    Customer customer = Customer.builder()
        .contact(customerContact)
        .build();

    //customerRepository.save(customer);

    Delivery delivery = new Delivery(
        new Address("Germany", "76187", "Karlsruhe", "Nancystraße 24."), DeliveryMethod.DHL);

    OrderDetails details = OrderDetails.builder()
        .delivery(delivery)
        .orderDateTime(time)
        .paymentMethod(PaymentMethod.PayPal)
        .build();

    //orderRepository.save(details);

  }

}

package webshop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webshop.model.*;
import webshop.repository.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public void run(String... args) throws Exception {
        CustomerName customerName = new CustomerName("John", "Doe");
        LocalDateTime time = LocalDateTime.now();

        Address address = new Address("1111 Budapest");

        List<Address> addressList = new LinkedList<>();
        addressList.add(address);



        ProductImage image = new ProductImage("https://pcbonlineshop.com/photos/product/4/176/4.jpg", "beats");
        ArrayList<ProductImage> images = new ArrayList<>();
        images.add(image);

        ProductCategory category = new ProductCategory("cat7");
        ArrayList<ProductCategory> categories = new ArrayList<>();
        categories.add(category);

        Product product = Product.builder()
                .name("product")
                .originalPrice(new Price(BigDecimal.valueOf(100), BigDecimal.valueOf(27)))
                .description("this is a p$roduct")
                .numberInStock(2)
                .images(images)
                .build();



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

        Delivery delivery = new Delivery(new Address("Karlsruhe"), DeliveryMethod.DHL);


        OrderDetails details = OrderDetails.builder()
                .delivery(delivery)
                .orderDateTime(time)
                .paymentMethod(PaymentMethod.PayPal)
                .build();

        //orderRepository.save(details);

    }

}

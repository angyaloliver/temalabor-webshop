package webshop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import webshop.model.Address;
import webshop.model.Customer;
import webshop.model.CustomerContact;
import webshop.model.CustomerName;
import webshop.model.Delivery;
import webshop.model.OrderDetails;
import webshop.model.OrderStatus;
import webshop.model.PaymentMethod;
import webshop.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

  @InjectMocks
  CustomerService customerService;

  @Mock
  CustomerRepository customerRepository;

  @Test
  public void testChangeContact() {
    Customer customer = new Customer();

    Integer customerId = 7777;
    LocalDateTime registrationDate = LocalDateTime.now();

    Address address = new Address();
    address.setAddress("example address");
    ArrayList<Address> addressList = new ArrayList<>();
    addressList.add(address);

    CustomerName oldCustomerName = new CustomerName("Jakab", "Gipsz");
    CustomerName newCustomerName = new CustomerName("Jakab", "Cement");

    String oldPhoneNumber = "+36303308600";
    String newPhoneNumber = "+36304409700";

    CustomerContact oldCustomerContact = CustomerContact.builder()
        .name(oldCustomerName)
        .emailAddress("gipsz.jakab@gmail.com")
        .phoneNumber(oldPhoneNumber)
        .registrationDateTime(registrationDate)
        .billingAddresses(addressList)
        .build();

    CustomerContact newCustomerContact = CustomerContact.builder()
        .name(newCustomerName)
        .emailAddress("gipsz.jakab@gmail.com")
        .phoneNumber(newPhoneNumber)
        .registrationDateTime(registrationDate)
        .billingAddresses(addressList)
        .build();

    customer.setId(customerId);
    customer.setContact(oldCustomerContact);

    Mockito.when(customerRepository.getOne(customerId)).thenReturn(customer);

    customerService.changeContact(customerId, newCustomerContact);

    Assert.assertEquals(newCustomerName.getFirstName(),
        customer.getContact().getName().getFirstName());

    Assert.assertEquals(newCustomerName.getLastName(),
        customer.getContact().getName().getLastName());

    Assert.assertEquals(newPhoneNumber, customer.getContact().getPhoneNumber());
  }

  @Test
  public void testAddOneOrder() {
    Integer customerId = 1111;
    Integer orderId = 7879;

    LocalDateTime dateTime = LocalDateTime.now();

    Customer customer = new Customer();
    customer.setId(customerId);

    OrderDetails orderDetails = OrderDetails.builder()
        .id(orderId)
        .orderDateTime(dateTime)
        .customer(customer)
        .delivery(new Delivery())
        .shoppingCart(customer.getShoppingCart())
        .paymentMethod(PaymentMethod.Simple)
        .status(OrderStatus.Processing)
        .build();

    Mockito.when(customerRepository.getOne(customerId)).thenReturn(customer);

    customerService.addOrder(customerId, orderDetails);

    Assert.assertEquals(1, customer.getOrderDetails().size());
    Assert.assertEquals(orderDetails, customer.getOrderDetails().iterator().next());
  }

  @Test
  public void testAddMultipleOrders() {
    Integer customerId = 1111;

    Integer orderId1 = 7879;
    Integer orderId2 = 3212;

    LocalDateTime dateTime1 = LocalDateTime.now();
    LocalDateTime dateTime2 = LocalDateTime.now().minusDays(3L);

    Customer customer = new Customer();
    customer.setId(customerId);

    OrderDetails orderDetails1 = OrderDetails.builder()
        .id(orderId1)
        .orderDateTime(dateTime1)
        .customer(customer)
        .delivery(new Delivery())
        .shoppingCart(customer.getShoppingCart())
        .paymentMethod(PaymentMethod.Simple)
        .status(OrderStatus.Processing)
        .build();

    OrderDetails orderDetails2 = OrderDetails.builder()
        .id(orderId2)
        .orderDateTime(dateTime2)
        .customer(customer)
        .delivery(new Delivery())
        .shoppingCart(customer.getShoppingCart())
        .paymentMethod(PaymentMethod.PayPal)
        .status(OrderStatus.Deliverd)
        .build();

    Mockito.when(customerRepository.getOne(customerId)).thenReturn(customer);

    customerService.addOrder(customerId, orderDetails1);
    customerService.addOrder(customerId, orderDetails2);

    Assert.assertEquals(2, customer.getOrderDetails().size());
    Assert.assertArrayEquals(Arrays.array(orderDetails1, orderDetails2),
        customer.getOrderDetails().toArray());
  }

}
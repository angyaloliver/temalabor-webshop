package webshop.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webshop.model.Delivery;
import webshop.model.OrderDetails;
import webshop.model.PaymentMethod;
import webshop.service.OrderService;


@AllArgsConstructor
@RestController
@RequestMapping("orders")
public class OrderController {

  OrderService orderService;

  @PostMapping
  public void createOrder(
      @PathVariable("id") Integer customerId,
      @PathVariable("id") Integer orderId,
      @PathVariable("id") Integer shoppingCartIdNew,
      @RequestBody Delivery delivery,
      @RequestBody PaymentMethod paymentMethod) {
    orderService.createOrder(customerId, orderId, delivery, paymentMethod, shoppingCartIdNew);
  }

  @DeleteMapping("{id}")
  public void deleteOrder(@PathVariable("id") Integer id) {
    orderService.deleteOrder(id);
  }

  // @GetMapping("{id}")
  public OrderDetails getOrderById(@PathVariable Integer id) {
    return orderService.getOrderById(id);
  }

  @GetMapping
  public List<OrderDetails> getAllOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("{id}")
  public List<OrderDetails> getOneCustomersAllOrders(@PathVariable Integer id) {
    return orderService.getOneCustomersAllOrders(id);
  }
}

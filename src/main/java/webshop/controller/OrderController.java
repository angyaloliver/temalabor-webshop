package webshop.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import webshop.model.Delivery;
import webshop.model.OrderDetails;
import webshop.model.OrderStatus;
import webshop.model.PaymentMethod;
import webshop.service.OrderService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("orders")
public class OrderController {

  OrderService orderService;

  @PostMapping
  public void createOrder(
      @PathVariable("customerId") Integer customerId,
      @RequestBody Delivery delivery){
      //@RequestBody PaymentMethod paymentMethod)
    orderService.createOrder(customerId, delivery, PaymentMethod.Simple);
  }

  @DeleteMapping("{id}")
  public void deleteOrder(@PathVariable("id") Integer id) {
    orderService.deleteOrder(id);
  }

  @GetMapping("{id}")
  public OrderDetails getOrderById(@PathVariable Integer id) {
    return orderService.getOrderById(id);
  }

  @GetMapping("/all")
  public List<OrderDetails> getAllOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("orders_of/{customerId}")
  public List<OrderDetails> getOneCustomersAllOrders(@PathVariable Integer customerId) {
    return orderService.getOneCustomersAllOrders(customerId);
  }

  @PatchMapping("changeStatus/{id}")
  public void changeOrderStatus(
          @PathVariable("id") Integer orderId,
          @RequestParam("status") Integer newStatus) {
    if(newStatus==1) {
      orderService.changeOrderStatus(orderId, OrderStatus.Processing);
    }
    if(newStatus==2) {
      orderService.changeOrderStatus(orderId, OrderStatus.Shipped);
    }
    if(newStatus==3) {
      orderService.changeOrderStatus(orderId, OrderStatus.Deliverd);
    }
  }
}

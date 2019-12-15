package webshop.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webshop.model.Product;
import webshop.service.ShoppingCartService;

@AllArgsConstructor
@RestController
@RequestMapping("shoppingcarts")
public class ShoppingCartController {

  ShoppingCartService shoppingCartService;

  @PatchMapping("add")
  public void addProductToCart(
      @RequestParam("productid") Integer productId,
      @RequestParam("customerid") Integer customerId) {
    shoppingCartService.addProductToCart(productId, customerId);
  }

  @PatchMapping("remove")
  public void removeProductFromCart(
      @RequestParam("productid") Integer productId,
      @RequestParam("customerid") Integer customerId) {
    shoppingCartService.removeProductFromCart(productId, customerId);
  }

  @GetMapping("/cart")
  public List<Product> getAllProductsInCart(
      @RequestParam("shoppingcartid") Integer shoppingCartId) {
    return shoppingCartService.getAllProductsInCart(shoppingCartId);
  }

}
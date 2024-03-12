package com.example.sst_cart.Controllers;

import com.example.sst_cart.Model.Cart;
import com.example.sst_cart.Services.CartServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartContoller {
    private final CartServices cartServices;


    public CartContoller(CartServices cartServices) {
        this.cartServices = cartServices;
    }
    @GetMapping("/cart")
    public List<Cart> getAllCarts(){
        return cartServices.getAllCart();
    }

    @GetMapping("/cart/{id}")
    public Cart getSingleCart(@PathVariable("id") Long id){
        return cartServices.getSingleCart(id);
    }

    @DeleteMapping("/cart/{id}")
    public Cart deleteCart(@PathVariable("id") Long id){
        return cartServices.deleteCart(id);
    }

    @PostMapping("/cart")
    public Cart addCart(@RequestBody Cart cart){
        return cartServices.addCart(cart);
    }

    @PutMapping("/update")
    public Cart updateCart(@RequestBody Cart cart){
        return cartServices.addCart(cart);
    }

    @GetMapping("/user/{userId}")
    public List<Cart> getByUser(@PathVariable("userId") Long id){
        return cartServices.getCartByUser(id);
    }

    @GetMapping("/date/{Start}/{End}")
    public List<Cart> getByDate(@PathVariable("Start") String Start, @PathVariable("End") String End){
        return cartServices.getByDate(Start,End);
    }
}

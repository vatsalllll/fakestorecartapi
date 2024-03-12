package com.example.sst_cart.Services;

import com.example.sst_cart.Model.Cart;

import java.util.List;

public interface CartServices {
    List<Cart> getAllCart();

    Cart getSingleCart(Long id);

    Cart deleteCart(Long id);

    Cart addCart(Cart cart);

    Cart updateCart(Cart cart);

    List<Cart> getCartByUser(Long userId);

    List<Cart> getByDate(String start_Date, String End_Date);
}

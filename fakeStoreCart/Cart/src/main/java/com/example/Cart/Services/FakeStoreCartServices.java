package com.example.sst_cart.Services;

import com.example.sst_cart.DTOs.FakeProductDTO;
import com.example.sst_cart.Model.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class FakeStoreCartServices implements CartServices {
    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Cart> getAllCart() {
        FakeProductDTO[] carts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                FakeProductDTO[].class
        );
        List<Cart> cartList = new ArrayList<>();
        for(FakeProductDTO ele : carts){
            Cart cart = new Cart();
            cart.setId(ele.getId());
            cart.setUserId(ele.getUserId());
            cart.setDate(ele.getDate());
            cart.setProducts(ele.getProducts());
            cartList.add(cart);
        }
        return cartList;
    }

    @Override
    public Cart getSingleCart(Long id) {
        FakeProductDTO prod = restTemplate.getForObject(
            "https://fakestoreapi.com/carts/"+id,
                FakeProductDTO.class
        );
        Cart cart = new Cart();
        cart.setId(prod.getId());
        cart.setDate(prod.getDate());
        cart.setDate(prod.getDate());
        cart.setProducts(prod.getProducts());
        return cart;
    }

    @Override
    public Cart deleteCart(Long id) {
        FakeProductDTO deletedCart = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/"+id,
                FakeProductDTO.class
        );
        Cart cart = new Cart();
        cart.setId(deletedCart.getId());
        cart.setDate(deletedCart.getDate());
        cart.setDate(deletedCart.getDate());
        cart.setProducts(deletedCart.getProducts());
        return cart;
    }

    @Override
    public Cart addCart(Cart cart) {
        Cart cartToAdd = new Cart();
        cartToAdd.setUserId(cart.getUserId());
        cartToAdd.setProducts(cart.getProducts());
        cartToAdd.setDate(cart.getDate());

        restTemplate.postForObject(
                "https://fakestoreapi.com/carts",
                cartToAdd,
                FakeProductDTO.class
        );
        return cartToAdd;
    }

    @Override
    public Cart updateCart(Cart cart) {
        Cart cartToAdd = new Cart();
        cartToAdd.setUserId(cart.getUserId());
        cartToAdd.setProducts(cart.getProducts());
        cartToAdd.setDate(cart.getDate());

        restTemplate.put(
                "https://fakestoreapi.com/carts/"+cart.getId(),
                cartToAdd,
                FakeProductDTO.class
        );
        return cartToAdd;
    }

    @Override
    public List<Cart> getCartByUser(Long userId) {
        FakeProductDTO[] carts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/user/"+userId,
                FakeProductDTO[].class
        );
        List<Cart> res = new ArrayList<>();
        for(FakeProductDTO ele : carts){
            Cart cartWithId = new Cart();
            cartWithId.setId(ele.getId());
            cartWithId.setUserId(ele.getUserId());
            cartWithId.setDate(ele.getDate());
            cartWithId.setProducts(ele.getProducts());
            res.add(cartWithId);
        }
        return res;
    }

    @Override
    public List<Cart> getByDate(String start_Date, String End_Date) {
        FakeProductDTO[] carts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts?startdate="+start_Date+"&enddate="+End_Date,
                FakeProductDTO[].class
        );
        List<Cart> res = new ArrayList<>();
        for(FakeProductDTO ele : carts){
            Cart cartWithId = new Cart();
            cartWithId.setId(ele.getId());
            cartWithId.setUserId(ele.getUserId());
            cartWithId.setDate(ele.getDate());
            cartWithId.setProducts(ele.getProducts());
            res.add(cartWithId);
        }
        return res;
    }


}

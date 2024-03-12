package com.example.sst_cart.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private long id;
    private long userId;
    private String date;
    private Product[] products;
}

package com.example.sst_cart.DTOs;

import com.example.sst_cart.Model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeProductDTO {
    private long id;
    private long userId;
    private String date;
    private Product[] products;
}

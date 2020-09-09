package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GiftsService {

    public String getAllGifts() {
        String gifts = "Look Some Gifts!";
        return gifts;
    }
}
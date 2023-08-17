package com.example.beeradviser;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {

    List<String> getBrands(String color){
        List<String> brands = new ArrayList<>();

        if(color.equals("amber")){
            brands.add("Jack ember");
            brands.add("Red moose");
        } else {
            brands.add("keru");
            brands.add("daru");
        }

        return brands;
    }
}

package org.example.beans;

import org.example.entity.Speaker;
import org.example.entity.Tyre;
import org.springframework.stereotype.Service;

@Service
public class TyreService {
    public Tyre generateTyre(){
        String brand= (Math.random()>0.5)? "Bridgestone" : "MRF";
        int price = (brand.equals("Bridgestone"))? 10000 : 15000;
        return new Tyre(brand,price);

    }
}

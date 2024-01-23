package org.example.services.factorytyreservice;


import org.example.entity.Tyre;
import org.example.services.TyreService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Factory1TyreService implements TyreService {

    public Tyre generateFactory1Tyre() {
        return generateTyre();
    }
}

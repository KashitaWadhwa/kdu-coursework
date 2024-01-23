// Factory1SpeakerService.java

package org.example.services.factorytyreservice;


import org.example.entity.Tyre;

import org.example.services.TyreService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Factory2TyreService implements TyreService {

    public Tyre generateFactory2Tyre() {
        return generateTyre();
    }
}

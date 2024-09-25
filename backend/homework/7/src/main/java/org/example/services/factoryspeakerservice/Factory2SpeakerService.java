package org.example.services.factoryspeakerservice;

import org.example.entity.Speaker;
import org.example.services.SpeakerService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Factory2SpeakerService implements SpeakerService {

    public Speaker generateFactory2Speaker() {
        return generateSpeaker();
    }
}

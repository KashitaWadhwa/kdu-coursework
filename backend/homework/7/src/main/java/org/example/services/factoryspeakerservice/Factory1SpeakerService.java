// Factory1SpeakerService.java

package org.example.services.factoryspeakerservice;

import org.example.entity.Speaker;
import org.example.services.SpeakerService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Factory1SpeakerService implements SpeakerService {

    // You can call the generateSpeaker method from the SpeakerService interface
    // This class may contain additional logic specific to Factory 1
    public Speaker generateFactory1Speaker() {
        return generateSpeaker();
    }
}

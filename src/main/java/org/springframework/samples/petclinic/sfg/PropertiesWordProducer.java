package org.springframework.samples.petclinic.sfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"externalized", "laurel-properties"})
@Primary
public class PropertiesWordProducer implements WordProducer {

    String word;

    @Override

    public String getWord() {

        return word;
    }
     @Value("${say.word}")
    public void setWord(String word) {
        this.word = word;
    }
}

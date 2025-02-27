package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.sfg.HearingInterp;
import org.springframework.samples.petclinic.sfg.LaurelWordProducer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("inner-class")
@SpringJUnitConfig(classes = HearingInterpInnerClassTest.TestConfig.class)
class HearingInterpInnerClassTest {

    @Profile("inner-class")
    @Configuration
    static class TestConfig{

        @Bean
        HearingInterp hearingInterp() {
            return new HearingInterp(new LaurelWordProducer());
        }
    }

    @Autowired
    HearingInterp hearingInterp;

    @Test
    void whatIHeard() {
        String word = hearingInterp.whatIHeard();
        assertEquals("Laurel", word);
    }
}
package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.HearingInterp;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.Assert.assertEquals;

@TestPropertySource("classpath:laurel.properties")
@ActiveProfiles("laurel-properties")
@SpringJUnitConfig(LaurelPropertiesTest.TestConfig.class)
public class LaurelPropertiesTest {

    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.sfg")
    static class TestConfig{

    }

    @Autowired
    HearingInterp hearingInterp;


    @Test
    void whatIHeard() {
        String word = hearingInterp.whatIHeard();
        assertEquals("LAUrel", word);
    }
}

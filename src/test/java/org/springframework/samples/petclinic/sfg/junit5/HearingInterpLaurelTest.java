package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.sfg.BaseConfig;
import org.springframework.samples.petclinic.sfg.HearingInterp;
import org.springframework.samples.petclinic.sfg.LaurelConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("base-test")
@SpringJUnitConfig({BaseConfig.class, LaurelConfig.class})
class HearingInterpLaurelTest {

    @Autowired
    HearingInterp hearingInterp;

    @Test
    void whatIHeard() {
        String word = hearingInterp.whatIHeard();
        assertEquals("Laurel", word);
    }
}
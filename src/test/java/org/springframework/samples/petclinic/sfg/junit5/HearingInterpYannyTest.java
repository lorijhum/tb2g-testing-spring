package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.sfg.BaseConfig;
import org.springframework.samples.petclinic.sfg.HearingInterp;
import org.springframework.samples.petclinic.sfg.YannyConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.Assert.assertEquals;

@SpringJUnitConfig({BaseConfig.class, YannyConfig.class})
class HearingInterpYannyTest {

    @Autowired
    HearingInterp hearingInterp;

    @Test
    void whatIHeard() {
        String word = hearingInterp.whatIHeard();
        assertEquals("Yanny", word);

    }
}
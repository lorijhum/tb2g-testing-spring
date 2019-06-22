package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-test-config.xml", "classpath:spring/mvc-core-config.xml"})
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {


    MockMvc mockMvc;

    @Autowired
    OwnerController ownerController;

    @Autowired
    ClinicService clinicService;

    @Mock
    Owner owner;

    @Mock
    Map<String, Object> ownerMap;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    Collection<Owner> owners;

    @Mock
    BindingResult result;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }


    @Test
    void initCreationForm() throws Exception {
        String view = "owners/createOrUpdateOwnerForm";
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(view().name(view));

    }

    @Test
    void findByNameNotFound() throws Exception {
        mockMvc.perform(get("/owners")
                .param("Last name", "Don't Find Me"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"));

    }

    @Test
    void findByOneNameFound() throws Exception {

        Owner owner = new Owner();
        owner.setLastName("Smith");
        owner.setId(1);
        owners.add(owner);
        Mockito.when(clinicService.findOwnerByLastName("Smith")).thenReturn(owners);
        System.out.println(owners.size());
        mockMvc.perform(get("/owners")
                .param("Last name", "Smith"))
                .andExpect(status().isOk());


        String view = "owners/ownersList";
        String returnedView = ownerController.processFindForm(owner, result, ownerMap);

        assertEquals(view, returnedView);


    }

}
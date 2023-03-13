package nvb.spring.cruddemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nvb.spring.cruddemo.model.Person;
import nvb.spring.cruddemo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static nvb.spring.cruddemo.MotherObject.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

@WebMvcTest(controllers = PersonController.class)
@ExtendWith(SpringExtension.class)
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    PersonService personService;

    @Test
    void findAll() throws Exception {
        when(personService.findAll()).thenReturn(List.of(anyPerson()));

        mockMvc.perform(get("/api/v1/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findPersonById() throws Exception {
        when(personService.findPersonById(ANY_ID)).thenReturn(anyPerson());

        mockMvc.perform(get("/api/v1/person/" + ANY_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void addPerson() throws Exception {
        when(personService.addPerson(anyPerson())).thenReturn(anyPerson());

        mockMvc.perform(post("/api/v1/person")
                        .content(objectMapper.writeValueAsString(anyPerson()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updatePerson() throws Exception {
        when(personService.updatePerson(any(Person.class))).thenReturn(anyPerson());

        mockMvc.perform(put("/api/v1/person")
                        .content(objectMapper.writeValueAsString(anyPerson()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void deletePersonById() throws Exception {
        doNothing().when(personService).deletePersonById(ANY_ID);

        mockMvc.perform(delete("/api/v1/person/" + ANY_ID))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void deleteAll() throws Exception {
        doNothing().when(personService).deleteAll();

        mockMvc.perform(delete("/api/v1/person"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findPersonByEmail() throws Exception {
        when(personService.findPersonByEmail(ANY_EMAIL)).thenReturn(Optional.of(anyPerson()));

        mockMvc.perform(get("/api/v1/personByEmail" + "?email=" + ANY_EMAIL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findPersonByCountry() throws Exception {
        when(personService.findPersonByCountry(ANY_COUNTRY)).thenReturn(Optional.of(anyPerson()));

        mockMvc.perform(get("/api/v1/personByCountry" + "?country=" + ANY_COUNTRY)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findPersonByCity() throws Exception {
        when(personService.findPersonByCity(ANY_CITY)).thenReturn(Optional.of(anyPerson()));

        mockMvc.perform(get("/api/v1/personByCity" + "?city=" + ANY_CITY)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findPersonByIsMarried() throws Exception {
        when(personService.findPersonByIsMarried(ANY_IS_MARRIED)).thenReturn(Optional.of(anyPerson()));

        mockMvc.perform(get("/api/v1/personByIsMarried" + "?isMarried=" + ANY_IS_MARRIED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void findPersonByFirstNameAndLastName() throws Exception {
        when(personService.findPersonByFirstNameAndLastName(ANY_FIRST_NAME, ANY_LAST_NAME))
                .thenReturn(Optional.of(anyPerson()));

        mockMvc.perform(get("/api/v1/personByFirstNameAndLastName" + "?firstName=" + ANY_FIRST_NAME +
                        "&lastName=" + ANY_FIRST_NAME)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}
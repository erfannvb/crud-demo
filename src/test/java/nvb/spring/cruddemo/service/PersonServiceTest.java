package nvb.spring.cruddemo.service;

import nvb.spring.cruddemo.exception.ResourceNotFoundException;
import nvb.spring.cruddemo.model.Person;
import nvb.spring.cruddemo.repository.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static nvb.spring.cruddemo.MotherObject.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @Test
    @DisplayName("find and return all persons")
    void find_and_return_all_persons() {
        when(personRepository.findAll()).thenReturn(List.of(anyPerson()));
        personService.findAll();
        verify(personRepository, atLeastOnce()).findAll();
    }

    @Test
    @DisplayName("find one person by id and return one person")
    void find_one_person_by_id_and_return_one_person() {
        when(personRepository.findById(ANY_ID)).thenReturn(Optional.of(anyPerson()));
        personService.findPersonById(ANY_ID);
        verify(personRepository, atLeastOnce()).findById(ANY_ID);
    }

    @Test
    @DisplayName("throw exception if a person does not exist")
    void throw_exception_if_a_person_does_not_exist() {
        when(personRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> personService.findPersonById(anyLong()));
        verify(personRepository, atLeastOnce()).findById(anyLong());
    }

    @Test
    @DisplayName("save one person")
    void save_one_person() {
        when(personRepository.save(any(Person.class))).thenReturn(anyPerson());
        personService.addPerson(anyPerson());
        verify(personRepository, atLeastOnce()).save(any(Person.class));
    }

    @Test
    @DisplayName("update one person")
    void update_one_person() {

    }

    @Test
    @DisplayName("delete person by id")
    void delete_person_by_id() {

    }

    @Test
    @DisplayName("delete all persons")
    void delete_all_persons() {
        doNothing().when(personRepository).deleteAll();
        personService.deleteAll();
        verify(personRepository, atLeastOnce()).deleteAll();
    }

    @Test
    @DisplayName("find a person by email and return person")
    void find_a_person_by_email_and_return_person() {
        when(personRepository.findPersonByEmail(any())).thenReturn(Optional.of(anyPerson()));
        personService.findPersonByEmail(ANY_EMAIL);
        verify(personRepository, atLeastOnce()).findPersonByEmail(ANY_EMAIL);
    }

    @Test
    @DisplayName("throw exception if person by email does not exist")
    void throw_exception_if_person_by_email_does_not_exist() {
        when(personRepository.findPersonByEmail(any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> personService.findPersonByEmail(any()));
        verify(personRepository, atLeastOnce()).findPersonByEmail(any());
    }

    @Test
    @DisplayName("find a person by country and return person")
    void find_a_person_by_country_and_return_person() {
        when(personRepository.findPersonByCountry(any())).thenReturn(Optional.of(anyPerson()));
        personService.findPersonByCountry(ANY_COUNTRY);
        verify(personRepository, atLeastOnce()).findPersonByCountry(ANY_COUNTRY);
    }

    @Test
    @DisplayName("throw exception if person by country does not exist")
    void throw_exception_if_person_by_country_does_not_exist() {
        when(personRepository.findPersonByCountry(any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> personService.findPersonByCountry(any()));
        verify(personRepository, atLeastOnce()).findPersonByCountry(any());
    }

    @Test
    @DisplayName("find a person by city and return person")
    void find_a_person_by_city_and_return_person() {
        when(personRepository.findPersonByCity(any())).thenReturn(Optional.of(anyPerson()));
        personService.findPersonByCity(ANY_CITY);
        verify(personRepository, atLeastOnce()).findPersonByCity(ANY_CITY);
    }

    @Test
    @DisplayName("throw exception if person by city does not exist")
    void throw_exception_if_person_by_city_does_not_exist() {
        when(personRepository.findPersonByCity(any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> personService.findPersonByCity(any()));
        verify(personRepository, atLeastOnce()).findPersonByCity(any());
    }

    @Test
    @DisplayName("find a person by isMarried and return person")
    void find_a_person_by_isMarried_and_return_person() {
        when(personRepository.findPersonByIsMarried(anyBoolean())).thenReturn(Optional.of(anyPerson()));
        personService.findPersonByIsMarried(ANY_IS_MARRIED);
        verify(personRepository, atLeastOnce()).findPersonByIsMarried(ANY_IS_MARRIED);
    }

    @Test
    @DisplayName("throw exception if person by isMarried does not exist")
    void throw_exception_if_person_by_isMarried_does_not_exist() {
        when(personRepository.findPersonByIsMarried(anyBoolean())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> personService.findPersonByIsMarried(anyBoolean()));
        verify(personRepository, atLeastOnce()).findPersonByIsMarried(anyBoolean());
    }

    @Test
    @DisplayName("find a person by firstName and lastName and return person")
    void find_a_person_by_firstName_and_lastName_and_return_person() {
        when(personRepository.findPersonByFirstNameAndLastName(ANY_FIRST_NAME, ANY_LAST_NAME)).thenReturn(Optional.of(anyPerson()));
        personService.findPersonByFirstNameAndLastName(ANY_FIRST_NAME, ANY_LAST_NAME);
        verify(personRepository, atLeastOnce()).findPersonByFirstNameAndLastName(ANY_FIRST_NAME, ANY_LAST_NAME);
    }

    @Test
    @DisplayName("throw exception if person by firstName and lastName does not exist")
    void throw_exception_if_person_by_firstName_and_lastName_does_not_exist() {
        when(personRepository.findPersonByFirstNameAndLastName(any(), any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> personService.findPersonByFirstNameAndLastName(any(), any()));
        verify(personRepository, atLeastOnce()).findPersonByFirstNameAndLastName(any(), any());
    }

}
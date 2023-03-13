package nvb.spring.cruddemo.controller;

import lombok.AllArgsConstructor;
import nvb.spring.cruddemo.model.Person;
import nvb.spring.cruddemo.service.PersonService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> findAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(personService.findAll(), headers, HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new ResponseEntity<>(personService.findPersonById(id), headers, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new ResponseEntity<>(personService.addPerson(person), headers, HttpStatus.CREATED);
    }

    @PutMapping("/person")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new ResponseEntity<>(personService.updatePerson(person), headers, HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public void deletePersonById(@PathVariable("id") Long id) {
        personService.deletePersonById(id);
    }

    @DeleteMapping("/person")
    public void deleteAll() {
        personService.deleteAll();
    }

    @GetMapping("/personByEmail")
    public ResponseEntity<Optional<Person>> findPersonByEmail(@RequestParam String email) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new ResponseEntity<>(personService.findPersonByEmail(email), headers, HttpStatus.OK);
    }

    @GetMapping("/personByCountry")
    public ResponseEntity<Optional<Person>> findPersonByCountry(@RequestParam String country) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new ResponseEntity<>(personService.findPersonByCountry(country), headers, HttpStatus.OK);
    }

    @GetMapping("/personByCity")
    public ResponseEntity<Optional<Person>> findPersonByCity(@RequestParam String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new ResponseEntity<>(personService.findPersonByCity(city), headers, HttpStatus.OK);
    }

    @GetMapping("/personByIsMarried")
    public ResponseEntity<Optional<Person>> findPersonByIsMarried(@RequestParam boolean isMarried) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new ResponseEntity<>(personService.findPersonByIsMarried(isMarried), headers, HttpStatus.OK);
    }

    @GetMapping("/personByFirstNameAndLastName")
    public ResponseEntity<Optional<Person>> findPersonByFirstNameAndLastName(@RequestParam String firstName,
                                                                             @RequestParam String lastName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new ResponseEntity<>(personService.findPersonByFirstNameAndLastName(firstName, lastName),
                headers, HttpStatus.OK);
    }

}

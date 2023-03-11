package nvb.spring.cruddemo.service;

import lombok.AllArgsConstructor;
import nvb.spring.cruddemo.exception.ResourceNotFoundException;
import nvb.spring.cruddemo.model.Person;
import nvb.spring.cruddemo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        Optional<Person> optionalPerson = personRepository.findById(person.getId());
        if (optionalPerson.isPresent()) {
            Person personUpdate = optionalPerson.get();
            personUpdate.setFirstName(person.getFirstName());
            personUpdate.setLastName(person.getLastName());
            personUpdate.setEmail(person.getEmail());
            personUpdate.setCountry(person.getCountry());
            personUpdate.setCity(person.getCity());
            personUpdate.setAge(person.getAge());
            personUpdate.setGender(person.getGender());
            personUpdate.setJob(person.getJob());
            personUpdate.setMarried(person.isMarried());
            return personUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + person.getId());
        }
    }

    public void deletePersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            personRepository.delete(optionalPerson.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }

    public Optional<Person> findPersonByEmail(String email) {
        Optional<Person> optionalPerson = personRepository.findPersonByEmail(email);
        if (optionalPerson.isPresent()) {
            return Optional.of(optionalPerson.get());
        } else {
            throw new ResourceNotFoundException("Record not found with email : " + email);
        }
    }

    public Optional<Person> findPersonByAge(int age) {
        Optional<Person> optionalPerson = personRepository.findPersonByAge(age);
        if (optionalPerson.isPresent()) {
            return Optional.of(optionalPerson.get());
        } else {
            throw new ResourceNotFoundException("Record not found with age : " + age);
        }
    }

    public Optional<Person> findPersonByCountry(String country) {
        Optional<Person> optionalPerson = personRepository.findPersonByCountry(country);
        if (optionalPerson.isPresent()) {
            return Optional.of(optionalPerson.get());
        } else {
            throw new ResourceNotFoundException("Record not found with country : " + country);
        }
    }

    public Optional<Person> findPersonByCity(String city) {
        Optional<Person> optionalPerson = personRepository.findPersonByCity(city);
        if (optionalPerson.isPresent()) {
            return Optional.of(optionalPerson.get());
        } else {
            throw new ResourceNotFoundException("Record not found with city : " + city);
        }
    }

    public Optional<Person> findPersonByIsMarried(boolean isMarried) {
        Optional<Person> optionalPerson = personRepository.findPersonByIsMarried(isMarried);
        if (optionalPerson.isPresent()) {
            return Optional.of(optionalPerson.get());
        } else {
            throw new ResourceNotFoundException("Record not found");
        }
    }

    public Optional<Person> findPersonByFirstNameAndLastName(String firstName, String lastName) {
        Optional<Person> optionalPerson = personRepository.findPersonByFirstNameAndLastName(firstName, lastName);
        if (optionalPerson.isPresent()) {
            return Optional.of(optionalPerson.get());
        } else {
            throw new ResourceNotFoundException("Record not found : " + firstName + " " + lastName);
        }
    }

}

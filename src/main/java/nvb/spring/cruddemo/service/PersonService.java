package nvb.spring.cruddemo.service;

import lombok.AllArgsConstructor;
import nvb.spring.cruddemo.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

}

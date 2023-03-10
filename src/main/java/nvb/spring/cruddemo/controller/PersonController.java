package nvb.spring.cruddemo.controller;

import lombok.AllArgsConstructor;
import nvb.spring.cruddemo.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

}

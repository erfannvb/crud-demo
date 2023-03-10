package nvb.spring.cruddemo.repository;

import nvb.spring.cruddemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByEmail(String email);

    Optional<Person> findPersonByAge(int age);

    Optional<Person> findPersonByCountry(String country);

    Optional<Person> findPersonByCity(String city);

    Optional<Person> findPersonByIsMarried(boolean isMarried);

    Optional<Person> findPersonByFirstNameAndLastName(String firstName, String lastName);

}

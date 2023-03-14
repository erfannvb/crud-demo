package nvb.spring.cruddemo;

import nvb.spring.cruddemo.model.Person;

public class MotherObject {

    public static final Long ANY_ID = 1L;
    public static final String ANY_FIRST_NAME = "firstName";
    public static final String ANY_LAST_NAME = "lastName";
    public static final String ANY_EMAIL = "any@gmail.com";
    public static final String ANY_COUNTRY = "country";
    public static final String ANY_CITY = "city";
    public static final String ANY_GENDER = "gender";
    public static final int ANY_AGE = 20;
    public static final String ANY_JOB = "job";
    public static final boolean ANY_IS_MARRIED = false;

    public static Person anyPerson() {
        Person person = Person.builder()
                .personId(ANY_ID)
                .firstName(ANY_FIRST_NAME)
                .lastName(ANY_LAST_NAME)
                .email(ANY_EMAIL)
                .country(ANY_COUNTRY)
                .city(ANY_CITY)
                .gender(ANY_GENDER)
                .age(ANY_AGE)
                .job(ANY_JOB)
                .isMarried(ANY_IS_MARRIED)
                .build();
        return person;
    }

}

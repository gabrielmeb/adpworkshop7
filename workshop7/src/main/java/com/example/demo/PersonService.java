package com.example.demo;

import com.example.demo.Person;
import com.example.demo.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setEmail(updatedPerson.getEmail());
                    return personRepository.save(person);
                })
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}

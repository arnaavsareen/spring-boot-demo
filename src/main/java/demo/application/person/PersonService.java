package demo.application.person;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Person with id " + id + " does not exist."));
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        boolean exists = personRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Person with id " + id + " does not exist.");
        }
        personRepository.deleteById(id);
    }

    public void updatePerson(Long id, Person updatedPerson) {
        Person existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Person with id " + id + " does not exist."));

        if (updatedPerson.getName() != null && !updatedPerson.getName().isEmpty()) {
            existingPerson.setName(updatedPerson.getName());
        }

        if (updatedPerson.getHobbies() != null && !updatedPerson.getHobbies().isEmpty()) {
            existingPerson.setHobbies(updatedPerson.getHobbies());
        }

        if (updatedPerson.getAddress() != null && !updatedPerson.getAddress().isEmpty()) {
            existingPerson.setAddress(updatedPerson.getAddress());
        }

        if (updatedPerson.getPhoneNumber() != null && !updatedPerson.getPhoneNumber().isEmpty()) {
            existingPerson.setPhoneNumber(updatedPerson.getPhoneNumber());
        }

        personRepository.save(existingPerson); 
    }
    
    public List<Person> getAllPersonWithHobby(String hobby) {
        return personRepository.findAll().stream()
                .filter(person -> person.getHobbies() != null && person.getHobbies().contains(hobby))
                .collect(Collectors.toList());
    }
}

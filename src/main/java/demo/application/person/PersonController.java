package demo.application.person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }

    @PutMapping("/{id}")
    public void updatePerson(
            @PathVariable("id") Long id,
            @RequestBody Person updatedPerson) {
        personService.updatePerson(id, updatedPerson);
    }
    
    @GetMapping(path = "hobby")
    public ResponseEntity<List<Person>> getAllPersonWithHobby(@RequestParam String hobby) {
        List<Person> personsWithHobby = personService.getAllPersonWithHobby(hobby);
        return ResponseEntity.ok(personsWithHobby);
    }
}
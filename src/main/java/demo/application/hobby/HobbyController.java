package demo.application.hobby;

import org.springframework.web.bind.annotation.*;

import demo.application.person.Person;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/hobbies")
public class HobbyController {

    private final HobbyService hobbyService;

    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @GetMapping
    public List<Hobby> getAllHobbies() {
        return hobbyService.getAllHobbies();
    }

    @GetMapping("/{id}")
    public Hobby getHobbyById(@PathVariable Long id) {
        return hobbyService.getHobbyById(id);
    }

    @PostMapping
    public void addHobby(@RequestBody Hobby hobby) {
        hobbyService.addHobby(hobby);
    }

    @DeleteMapping("/{id}")
    public void deleteHobby(@PathVariable("id") Long id) {
        hobbyService.deleteHobby(id);
    }

    @PutMapping("/{id}")
    public void updateHobby(
            @PathVariable("id") Long id,
            @RequestBody Hobby updatedHobby) {
        hobbyService.updateHobby(id, updatedHobby);
    }

    @GetMapping("/{name}/persons")
    public List<Person> getPersonsByHobby(@PathVariable String name) {
        return hobbyService.getPersonsByHobby(name);
    }
}

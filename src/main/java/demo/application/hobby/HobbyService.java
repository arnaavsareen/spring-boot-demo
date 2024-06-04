package demo.application.hobby;

import demo.application.person.Person;
import demo.application.person.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {

    private final HobbyRepository hobbyRepository;
    private final PersonRepository personRepository;

    public HobbyService(HobbyRepository hobbyRepository, PersonRepository personRepository) {
        this.hobbyRepository = hobbyRepository;
        this.personRepository = personRepository;
    }

    public List<Hobby> getAllHobbies() {
        return hobbyRepository.findAll();
    }

    public Hobby getHobbyById(Long id) {
        return hobbyRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Hobby with id " + id + " does not exist."));
    }

    public void addHobby(Hobby hobby) {
        hobbyRepository.save(hobby);
    }

    public void deleteHobby(Long id) {
        boolean exists = hobbyRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Hobby with id " + id + " does not exist.");
        }
        hobbyRepository.deleteById(id);
    }

    public void updateHobby(Long id, Hobby updatedHobby) {
        Hobby existingHobby = hobbyRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Hobby with id " + id + " does not exist."));

        if (updatedHobby.getName() != null && !updatedHobby.getName().isEmpty()) {
            existingHobby.setName(updatedHobby.getName());
        }

        hobbyRepository.save(existingHobby);  
    }

    public List<Person> getPersonsByHobby(String hobbyName) {
        return personRepository.findAll().stream()
                .filter(person -> person.getHobbies().contains(hobbyName))
                .toList();
    }
}

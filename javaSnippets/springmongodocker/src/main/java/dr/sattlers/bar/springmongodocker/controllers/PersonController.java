package dr.sattlers.bar.springmongodocker.controllers;

import dr.sattlers.bar.springmongodocker.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final List<Person> people = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Long id = counter.incrementAndGet();
        person.setId(id);
        people.add(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        return people.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @RequestBody Person updatedPerson) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                person.setFirstName(updatedPerson.getFirstName());
                person.setLastName(updatedPerson.getLastName());
                return new ResponseEntity<>(person, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {
        boolean removed = people.removeIf(person -> person.getId().equals(id));
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


package gr.publicsoft.springbootcrud.controller;

import gr.publicsoft.springbootcrud.exception.*;
import gr.publicsoft.springbootcrud.model.Person;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepo;

    @GetMapping("persons")
    public List<Person> getPersonList(){
        return personRepo.findAll();
    }

    @GetMapping("persons/{id}")
    public Person getPersonById(@PathVariable long personId) throws ObjectNotFoundException {
        return personRepo.findById(personId)
                .orElseThrow(() -> new ObjectNotFoundException("Person with this id not found"));
    }

    @PostMapping("persons")
    public Person addPerson(@Valid @RequestBody Person person){
        return personRepo.save(person);
    }

}

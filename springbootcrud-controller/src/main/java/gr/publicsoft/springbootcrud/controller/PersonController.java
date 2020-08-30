package gr.publicsoft.springbootcrud.controller;

import gr.publicsoft.springbootcrud.model.Person;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RestController
//public class PersonController {
//
//        @Autowired
//        PersonValidator personValidator;
//    @Autowired
//    PersonService personService;
//
//    @InitBinder
//    private void initBinder(WebDataBinder binder) {
//        binder.addValidators(personValidator);
//    }
//
//    @GetMapping("persons")
//    public List<Person> getPersonList(@RequestParam(required = false) String companyName,
//                                      @RequestParam(required = false) String vatNumber ){
//        return personService.getListPersons();
//    }
//
//    @GetMapping("/person")
//    public String preRegister(ModelMap mm) {
//        Supplier supplier = new Supplier();
//        mm.addAttribute("supplier", supplier);
//        return "newPerson"; //register.jsp
//    }
//
//    @PostMapping("person")
//    // public Supplier addSupplier(@ModelAttribute("supplier") Supplier supplier) throws SupplierNotFoundException {
//    public String addSupplier(@Valid @RequestBody Supplier supplier, BindingResult bindingResult, ModelMap mm) {
//        if (bindingResult.hasErrors()) {
//            return "newPerson";
//        }
//        return "redirect:/person";
//    }
//}

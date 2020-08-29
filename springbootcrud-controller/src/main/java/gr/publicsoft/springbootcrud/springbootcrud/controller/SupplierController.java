package gr.publicsoft.springbootcrud.springbootcrud.controller;

import gr.publicsoft.springbootcrud.model.Supplier;
import java.util.List;

import gr.publicsoft.springbootcrud.services.SupplierService;
import gr.publicsoft.springbootcrud.springbootcrud.exception.SupplierNotFoundException;
import gr.publicsoft.springbootcrud.springbootcrud.validators.SupplierValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class SupplierController {
    
    @Autowired
    SupplierService supplierService;
    @Autowired
    SupplierValidator supplierValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(supplierValidator);
    }

    @GetMapping("supplier")
    public List<Supplier> getSuppliersList( @RequestParam(required = false) String companyName,
                                            @RequestParam(required = false) String vatNumber ){
        return supplierService.supplierList();
    }

    @GetMapping("/preregister")
    public String preRegister(ModelMap mm) {
        Supplier supplier = new Supplier();
        mm.addAttribute("supplier", supplier);
        return "newSupplier"; //register.jsp
    }

    @PostMapping("supplier")
   // public Supplier addSupplier(@ModelAttribute("supplier") Supplier supplier) throws SupplierNotFoundException {
    public String addSupplier(@Valid @RequestBody Supplier supplier, BindingResult bindingResult, ModelMap mm) throws SupplierNotFoundException {
        if (bindingResult.hasErrors()) {
            return "newSupplier";
        }
        return "redirect:/supplier";
    }
}

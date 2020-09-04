package gr.publicsoft.springbootcrud.controller;

import gr.publicsoft.springbootcrud.exception.NotValidNumberInPageNumber;
import gr.publicsoft.springbootcrud.exception.ObjectNotFoundException;
import gr.publicsoft.springbootcrud.exception.ExistUniqueValueException;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    /**
     * Get supplier list
     *
     * @param query
     * @return the list of supplier
     * @throws NotValidNumberInPageNumber
     */
    @GetMapping("suppliers/{pageNumber}")
    public Page<Supplier> getSuppliersList(@PathVariable("pageNumber") int currentPage,
                                           @RequestParam(required = false) String query) throws NotValidNumberInPageNumber {
        //  @Param("query") String query) {
        return supplierService.supplierList(currentPage, query);
    }

    /**
     * Add supplier in db
     *
     * @param supplier
     * @return the supplier which added in database
     * @throws ExistUniqueValueException
     * @throws ObjectNotFoundException
     */
    @PostMapping("suppliers")
    public Supplier addSupplier(@Valid @RequestBody Supplier supplier) throws ObjectNotFoundException, ExistUniqueValueException {
        return supplierService.addSupplier(supplier);
    }

    /**
     * Update Supplier
     *
     * @param supplier
     * @param supplierId
     * @return the supplier which updated
     * @throws ObjectNotFoundException
     * @throws ExistUniqueValueException
     */
    @PutMapping("suppliers/{supplierId}")
    public Supplier updateSupplierById(@Valid @RequestBody Supplier supplier, @PathVariable long supplierId) throws ObjectNotFoundException, ExistUniqueValueException {
        return supplierService.updateSupplier(supplier, supplierId);
    }

    /**
     * Delete supplier by id
     *
     * @param supplierId
     * @return true if the deletion is successful
     * @throws ObjectNotFoundException
     */
    @DeleteMapping("suppliers/{supplierId}")
    public boolean deleteSupplier(@PathVariable long supplierId) throws ObjectNotFoundException {
        return supplierService.deleteSupplier(supplierId);
    }
}

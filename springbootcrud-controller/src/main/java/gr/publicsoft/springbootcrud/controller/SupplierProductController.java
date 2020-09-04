package gr.publicsoft.springbootcrud.controller;

import gr.publicsoft.springbootcrud.exception.ExistUniqueValueException;
import gr.publicsoft.springbootcrud.exception.NotValidNumberInPageNumber;
import gr.publicsoft.springbootcrud.exception.ObjectNotFoundException;
import gr.publicsoft.springbootcrud.model.SupplierProduct;
import gr.publicsoft.springbootcrud.services.SupplierProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierProductController {
    @Autowired
    SupplierProductService supplierProductService;

    /**
     * Create the relation between supplier and product
     *
     * @param supplierId
     * @param productId
     * @return the new object
     * @throws ObjectNotFoundException
     */
    @PostMapping("supplierproduct/{supplierId}/{productId}")
    public SupplierProduct addSupplierProduct(@PathVariable int supplierId, @PathVariable int productId) throws ObjectNotFoundException, ExistUniqueValueException {
        return supplierProductService.addSupplierProduct(supplierId, productId);
    }

    /**
     * List of supplier product
     *
     * @param currentPage
     * @param query
     * @return List of supplier product
     * @throws NotValidNumberInPageNumber
     */
    @GetMapping("supplierproduct/{pageNumber}")
    Page<SupplierProduct> listOfSuppliersWhichHaveTheSameProduct(@PathVariable("pageNumber") int currentPage, @RequestParam(required = false) String query) throws NotValidNumberInPageNumber {
        return supplierProductService.listOfSuppliersWhichHaveTheSameProduct(currentPage, query);
    }

}

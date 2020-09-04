package gr.publicsoft.springbootcrud.controller;

import gr.publicsoft.springbootcrud.exception.ExistUniqueValueException;
import gr.publicsoft.springbootcrud.exception.NotValidNumberInPageNumber;
import gr.publicsoft.springbootcrud.exception.ObjectNotFoundException;
import gr.publicsoft.springbootcrud.model.Product;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.services.ProductService;
import gr.publicsoft.springbootcrud.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    
    /**
     * Get product list
     *
     * @param currentPage
     * @param query
     * @return the list of product
     * @throws NotValidNumberInPageNumber
     */
    @GetMapping("products/{pageNumber}")
    public Page<Product> getProductList(@PathVariable("pageNumber") int currentPage,
                                        @RequestParam(required = false) String query) throws NotValidNumberInPageNumber {
        return productService.productList(currentPage, query);
    }

    /**
     * Add product in db
     *
     * @param product
     * @return the product which added in database
     * @throws ExistUniqueValueException
     * @throws ObjectNotFoundException
     */
    @PostMapping("products")
    public Product addProduct(@Valid @RequestBody Product product) throws ObjectNotFoundException, ExistUniqueValueException {
        return productService.addProduct(product);
    }

    /**
     * Update Product
     *
     * @param product
     * @param productId
     * @return the product which updated
     * @throws ObjectNotFoundException
     * @throws ExistUniqueValueException
     */
    @PutMapping("products/{productId}")
    public Product updateProductById(@Valid @RequestBody Product product, @PathVariable long productId) throws ObjectNotFoundException, ExistUniqueValueException {
        return productService.updateProduct(product, productId);
    }

    /**
     * Delete product by id
     *
     * @param productId
     * @return true if the deletion is successful
     * @throws ObjectNotFoundException
     */
    @DeleteMapping("products/{productId}")
    public boolean deleteProduct(@PathVariable long productId) throws ObjectNotFoundException {
        return productService.deleteProduct(productId);
    }
}

package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.exception.ExistUniqueValueException;
import gr.publicsoft.springbootcrud.exception.NotValidNumberInPageNumber;
import gr.publicsoft.springbootcrud.exception.ObjectNotFoundException;
import gr.publicsoft.springbootcrud.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<Product> productList(int pageNumber, String query) throws NotValidNumberInPageNumber;

    Product addProduct(Product product) throws ObjectNotFoundException, ExistUniqueValueException;

    Product updateProduct(Product product, long productId) throws ObjectNotFoundException, ExistUniqueValueException;

    boolean deleteProduct(long productId) throws ObjectNotFoundException;

    boolean checkIfExistBarCode(String barCode);

}

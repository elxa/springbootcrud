package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.exception.ExistUniqueValueException;
import gr.publicsoft.springbootcrud.exception.NotValidNumberInPageNumber;
import gr.publicsoft.springbootcrud.exception.ObjectNotFoundException;
import gr.publicsoft.springbootcrud.model.SupplierProduct;
import org.springframework.data.domain.Page;

public interface SupplierProductService {

    SupplierProduct addSupplierProduct(long supplierId, long productId) throws ObjectNotFoundException, ExistUniqueValueException;

    Page<SupplierProduct> listOfSuppliersWhichHaveTheSameProduct(int pageNumber, String query) throws NotValidNumberInPageNumber;

    boolean checkIfExistThisRelation(long supplierId, long productId);
}

package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.exception.*;
import gr.publicsoft.springbootcrud.model.Supplier;
import org.springframework.data.domain.Page;

public interface SupplierService {
    Page<Supplier> supplierList(int pageNumber,String query) throws NotValidNumberInPageNumber;

    Supplier addSupplier(Supplier supplier) throws ObjectNotFoundException, ExistUniqueValueException;

    Supplier updateSupplier(Supplier suppler, long supplierId) throws ObjectNotFoundException, ExistUniqueValueException;

    boolean deleteSupplier(long supplierId) throws ObjectNotFoundException;

    boolean checkIfExistVatNumber(String vatNumber);

}

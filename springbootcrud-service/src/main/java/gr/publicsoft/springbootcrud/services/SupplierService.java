package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.exception.*;
import gr.publicsoft.springbootcrud.model.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {
    Page<Supplier> supplierList(int pageNumber,String query);

    Supplier getSupplierById(long supplierId) throws ObjectNotFoundException;

    Supplier addSupplier(Supplier supplier) throws ObjectNotFoundException, VatNumberException;

    Supplier updateSupplier(Supplier suppler, long supplierId) throws ObjectNotFoundException, VatNumberException;

    boolean deleteSupplier(long supplierId) throws ObjectNotFoundException;

    boolean checkIfExistVatNumber(String vatNumber);

}

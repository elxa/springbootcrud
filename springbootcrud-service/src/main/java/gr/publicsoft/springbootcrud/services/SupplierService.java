package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.exception.FieldSizeException;
import gr.publicsoft.springbootcrud.exception.SupplierNotFoundException;
import gr.publicsoft.springbootcrud.exception.SupplierNotValidFields;
import gr.publicsoft.springbootcrud.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> supplierList();

    Supplier addSupplier(Supplier supplier) throws SupplierNotFoundException, SupplierNotValidFields, FieldSizeException;

    Supplier updateSupplier(Supplier suppler, long supplierId) throws SupplierNotFoundException, SupplierNotValidFields, FieldSizeException;

    boolean deleteSupplier(long supplierId) throws SupplierNotFoundException;

    void checkSupplier(Supplier supplier) throws SupplierNotValidFields, SupplierNotFoundException, FieldSizeException;
}

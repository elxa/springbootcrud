package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.springbootcrud.exception.SupplierNotFoundException;

import java.util.List;

public interface SupplierService {
    List<Supplier> supplierList();

    void addSupplier(Supplier supplier) throws SupplierNotFoundException;
}

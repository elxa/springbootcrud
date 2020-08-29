package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import java.util.List;

import gr.publicsoft.springbootcrud.springbootcrud.exception.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SupplierRepository supplierRepo;
    
    @Override
    public List<Supplier> supplierList() {
        System.out.println("*************************************"+supplierRepo.findAll());
        return supplierRepo.findAll();
    }

    @Override
    public void addSupplier(Supplier supplier) throws SupplierNotFoundException {
        if(supplier == null){
            throw new SupplierNotFoundException("Applicant Not found");
        }
        //if(supplier.getCompanyName().length() > supplier )
        supplierRepo.save(supplier);
    }

}

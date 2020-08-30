package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.Constants;
import gr.publicsoft.springbootcrud.exception.FieldSizeException;
import gr.publicsoft.springbootcrud.exception.SupplierNotFoundException;
import gr.publicsoft.springbootcrud.exception.SupplierNotValidFields;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SupplierRepository supplierRepo;
    
    @Override
    public List<Supplier> supplierList() {
        return supplierRepo.findAll();
    }

    @Override
    public Supplier addSupplier(Supplier supplier) throws SupplierNotFoundException, SupplierNotValidFields, FieldSizeException {
        checkSupplier(supplier);
        return supplierRepo.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Supplier supplier, long supplierId) throws SupplierNotFoundException, SupplierNotValidFields, FieldSizeException {
        Supplier supplierInDb = supplierRepo.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException("supplier not found"));

        checkSupplier(supplier);
        supplierInDb.setCompanyName(supplier.getCompanyName());
        supplierInDb.setFirstName(supplier.getFirstName());
        supplierInDb.setLastName(supplier.getLastName());
        supplierInDb.setVatNumber(supplier.getVatNumber());
        supplierInDb.setIrsOffice(supplier.getIrsOffice());
        supplierInDb.setAddress(supplier.getAddress());
        supplierInDb.setZipCode(supplier.getZipCode());
        supplierInDb.setCity(supplier.getCity());
        supplierInDb.setCountry(supplier.getCountry());

        supplierRepo.save(supplierInDb);
        return null;
    }

    @Override
    public boolean deleteSupplier(long supplierId) throws SupplierNotFoundException {

        Optional<Supplier> oSupplier = supplierRepo.findById(supplierId);
        if (oSupplier.isPresent()) { //ean uparxei epistrefei to jobOffer
            supplierRepo.deleteById(supplierId);
            return true;
        } else throw new SupplierNotFoundException("Supplier Not Found");
    }


    @Override
    public void checkSupplier(Supplier supplier) throws SupplierNotValidFields, SupplierNotFoundException, FieldSizeException {
        if (supplier == null) {
            throw new SupplierNotFoundException("Supplier Not found");
        }
        if (StringUtils.isEmpty(supplier.getCompanyName())
                || StringUtils.isEmpty(supplier.getVatNumber())) {
            throw new SupplierNotValidFields("Supplier field not be null");
        }
        if (supplier.getCompanyName().length() > Constants.SIZE_M
                || supplier.getFirstName().length() > Constants.SIZE_M
                || supplier.getLastName().length() > Constants.SIZE_M
                || supplier.getVatNumber().length() > Constants.SIZE_M
                || supplier.getIrsOffice().length() > Constants.SIZE_M
                || supplier.getAddress().length() > Constants.SIZE_M
                || supplier.getZipCode().length() > Constants.SIZE_M
                || supplier.getCity().length() > Constants.SIZE_M
                || supplier.getCountry().length() > Constants.SIZE_M) {
            throw new FieldSizeException("Not valid size");
        }
    }

}

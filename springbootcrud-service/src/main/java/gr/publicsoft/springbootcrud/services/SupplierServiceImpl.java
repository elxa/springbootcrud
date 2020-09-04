package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.exception.*;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SupplierRepository supplierRepo;

    /**
     * A list of suppliers
     *
     * @param pageNumber
     * @param query
     * @return a list of suppliers
     * @throws NotValidNumberInPageNumber
     */
    @Override
    public Page<Supplier> supplierList(int pageNumber, String query) throws NotValidNumberInPageNumber {
        if(pageNumber <= 0){
            throw new NotValidNumberInPageNumber("Page number mustn't be 0, or negative number");
        }
        Pageable pageable = PageRequest.of(pageNumber-1, 10); //prwth selida einai h 0 me 10 element
        if(query != null){
            return supplierRepo.findByQuery(query,pageable);
        }
        return supplierRepo.findAll(pageable);
    }

    /**
     * Add supplier in db
     *
     * @param supplier
     * @return the supplier which added in database
     * @throws ExistUniqueValueException
     */
    @Override
    public Supplier addSupplier(Supplier supplier) throws ExistUniqueValueException {
        if(checkIfExistVatNumber(supplier.getVatNumber())==true){
            throw new ExistUniqueValueException("This vatNumber Already exists");
        }
        return supplierRepo.save(supplier);
    }

    /**
     * Update Supplier
     *
     * @param supplier
     * @param supplierId
     * @return the supplier which updated
     * @throws ObjectNotFoundException
     * @throws ExistUniqueValueException
     */
    @Override
    public Supplier updateSupplier(Supplier supplier, long supplierId) throws ObjectNotFoundException, ExistUniqueValueException {
        Supplier supplierInDb = supplierRepo.findById(supplierId)
                .orElseThrow(() -> new ObjectNotFoundException("Supplier not found"));

        if(checkIfExistVatNumber(supplier.getVatNumber())==true){
            throw new ExistUniqueValueException("This vatNumber Already exists");
        }
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
        return supplierInDb;
    }

    /**
     * Delete supplier by id
     *
     * @param supplierId
     * @return true if the deletion is successful
     * @throws ObjectNotFoundException
     */
    @Override
    public boolean deleteSupplier(long supplierId) throws ObjectNotFoundException {

        Optional<Supplier> oSupplier = supplierRepo.findById(supplierId);
        if (oSupplier.isPresent()) { //ean uparxei epistrefei to jobOffer
            supplierRepo.deleteById(supplierId);
            return true;
        } else throw new ObjectNotFoundException("Supplier Not Found");
    }

    /**
     * Check if vatNumber already exists in the db
     *
     * @param vatNumber
     * @return true if vatNumber already exists
     */
    @Override
    public boolean checkIfExistVatNumber(String vatNumber) {
        if(supplierRepo.findByVatNumber(vatNumber) != null ){
            return true;
        }
        return false;
    }
}

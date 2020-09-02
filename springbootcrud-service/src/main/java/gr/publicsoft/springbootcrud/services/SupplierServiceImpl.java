package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.Constants;
import gr.publicsoft.springbootcrud.exception.*;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SupplierRepository supplierRepo;

    @Override
    public Page<Supplier> supplierList(int pageNumber, String query) {
        Pageable pageable = PageRequest.of(pageNumber-1, 6); //prwth selida einai h 0 me 6 element
        if(query != null){
            return supplierRepo.findByQuery(query,pageable);
        }
        return supplierRepo.findAll(pageable);
    }

    @Override
    public Supplier getSupplierById(long supplierId) throws ObjectNotFoundException {
        Optional<Supplier> oSupplier = supplierRepo.findById(supplierId);
        if (oSupplier.isPresent()) {
            return oSupplier.get();
        } else throw new ObjectNotFoundException("Supplier not found");
    }

    /**
     * Add supplier in db
     *
     * @param supplier
     * @return the supplier which added in database
     * @throws VatNumberException
     */
    @Override
    public Supplier addSupplier(Supplier supplier) throws VatNumberException {
        if(checkIfExistVatNumber(supplier.getVatNumber())==true){
            throw new VatNumberException("This vatNumber Already exists");
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
     * @throws VatNumberException
     */
    @Override
    public Supplier updateSupplier(Supplier supplier, long supplierId) throws ObjectNotFoundException, VatNumberException {
        Supplier supplierInDb = supplierRepo.findById(supplierId)
                .orElseThrow(() -> new ObjectNotFoundException("Supplier not found"));

        if(checkIfExistVatNumber(supplier.getVatNumber())==true){
            throw new VatNumberException("This vatNumber Already exists");
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

    @Override
    public boolean checkIfExistVatNumber(String vatNumber) {
        if(supplierRepo.findByVatNumber(vatNumber) != null ){
            return true;
        }
        return false;
    }





//    /**
//     * Check the supplier properties
//     *
//     * @param supplier
//     * @throws SupplierNotValidFields
//     * @throws ObjectNotFoundException
//     * @throws FieldSizeException
//     */
//    @Override
//    public void checkSupplier(Supplier supplier) throws SupplierNotValidFields, ObjectNotFoundException, FieldSizeException, NotCharactersFields, NotNumercsFields {
//        if (supplier == null) {
//            throw new ObjectNotFoundException("Supplier Not found");
//        }
//        if (StringUtils.isEmpty(supplier.getCompanyName())
//                || StringUtils.isEmpty(supplier.getFirstName())
//                || StringUtils.isEmpty(supplier.getLastName())
//                || StringUtils.isEmpty(supplier.getVatNumber())
//                || StringUtils.isEmpty(supplier.getZipCode())
//                || StringUtils.isEmpty(supplier.getCity())
//                || StringUtils.isEmpty(supplier.getCountry())) {
//            throw new SupplierNotValidFields("Supplier field not be null or empty");
//        }
//        if (supplier.getAddress() == null
//                ||supplier.getIrsOffice() == null) {
//            throw new SupplierNotValidFields("Supplier field not be null");
//        }
//        if (supplier.getCompanyName().length() > Constants.SIZE_M
//                || supplier.getFirstName().length() > Constants.SIZE_M
//                || supplier.getLastName().length() > Constants.SIZE_M
//                || supplier.getVatNumber().length() > Constants.SIZE_M
//                || supplier.getIrsOffice().length() > Constants.SIZE_M
//                || supplier.getAddress().length() > Constants.SIZE_M
//                || supplier.getZipCode().length() > Constants.SIZE_M
//                || supplier.getCity().length() > Constants.SIZE_M
//                || supplier.getCountry().length() > Constants.SIZE_M) {
//            throw new FieldSizeException("Not valid size");
//        }
//        if (isStringOnlyAlphabet(supplier.getCompanyName()) == false
//                || isStringOnlyAlphabet(supplier.getFirstName()) == false
//                || isStringOnlyAlphabet(supplier.getLastName()) == false
//                || isStringOnlyAlphabet(supplier.getCity()) == false
//                || isStringOnlyAlphabet(supplier.getCountry()) == false) {
//            throw new NotCharactersFields("Required only characters");
//        }
//        if (isStringOnlyNumer(supplier.getZipCode())== false
//                || isStringOnlyNumer(supplier.getVatNumber())== false) {
//            throw new NotNumercsFields("Required only numbers");
//        }
//    }

}

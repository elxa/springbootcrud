package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.exception.ExistUniqueValueException;
import gr.publicsoft.springbootcrud.exception.NotValidNumberInPageNumber;
import gr.publicsoft.springbootcrud.exception.ObjectNotFoundException;
import gr.publicsoft.springbootcrud.model.Product;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.model.SupplierProduct;
import gr.publicsoft.springbootcrud.repository.ProductRepository;
import gr.publicsoft.springbootcrud.repository.SupplierProductRepository;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierProductServiceImpl implements SupplierProductService{

    @Autowired
    SupplierRepository supplierRepo;
    @Autowired
    ProductRepository productRepo;
    @Autowired
    SupplierProductRepository supplierProductRepo;

    /**
     * Create the relation between supplier and product
     * @param supplierId
     * @param productId
     * @return the new object
     * @throws ObjectNotFoundException
     */
    @Override
    public SupplierProduct addSupplierProduct(long supplierId, long productId) throws ObjectNotFoundException, ExistUniqueValueException {

        Supplier supplierInDb = supplierRepo.findById(supplierId)
                .orElseThrow(
                        () -> new ObjectNotFoundException("Supplier not found")
                );

        Product productInDb = productRepo.findById(productId)
                .orElseThrow(
                        () -> new ObjectNotFoundException("Product not found")
                );

        if(checkIfExistThisRelation(supplierId, productId)==true){
            throw new ExistUniqueValueException("This relation Already exists");
        }
        SupplierProduct supplierProduct = new SupplierProduct();
        supplierProduct.setProduct(productInDb);
        supplierProduct.setSupplier(supplierInDb);
        return supplierProductRepo.save(supplierProduct);
    }

    /**
     * List of supplier product
     * @param pageNumber
     * @param query
     * @return List of supplier product
     * @throws NotValidNumberInPageNumber
     */
    @Override
    public Page<SupplierProduct> listOfSuppliersWhichHaveTheSameProduct(int pageNumber, String query) throws NotValidNumberInPageNumber {
        if(pageNumber <= 0){
            throw new NotValidNumberInPageNumber("Page number mustn't be 0, or negative number");
        }
        Pageable pageable = PageRequest.of(pageNumber-1, 10); //prwth selida einai h 0 me 10 element
        if(query != null){
            return supplierProductRepo.findByQuery(query,pageable);
        }
        return supplierProductRepo.findAll(pageable);
    }

    /**
     * Check if the relation between supplier and product already exists in the db
     *
     * @param supplierId
     * @param productId
     * @return true if relation already exists
     */
    @Override
    public boolean checkIfExistThisRelation(long supplierId, long productId) {
        if(supplierProductRepo.checkIfExistThisRelation(supplierId,productId) != null ){
            return true;
        }
        return false;
    }

//    @Override
//    public List<SupplierProductDto> listOfSuppliersWhichHaveTheSameProduct(String barCode) throws NotValidNumberInPageNumber {
////        if(pageNumber <= 0){
////            throw new NotValidNumberInPageNumber("Page number mustn't be 0, or negative number");
////        }
////        Pageable pageable = PageRequest.of(pageNumber-1, 10); //prwth selida einai h 0 me 10 element
////        if(query != null){
//        return supplierProductRepo.findProductInCompanies(barCode);
////        }
////        return supplierProductRepo.findAll(pageable);
//    }
}

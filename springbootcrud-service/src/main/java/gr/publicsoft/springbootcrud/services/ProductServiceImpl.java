package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.exception.NotValidNumberInPageNumber;
import gr.publicsoft.springbootcrud.exception.ObjectNotFoundException;
import gr.publicsoft.springbootcrud.exception.ExistUniqueValueException;
import gr.publicsoft.springbootcrud.model.Product;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepo;

    /**
     * A list of products
     *
     * @param pageNumber
     * @param query
     * @return a list of products
     * @throws NotValidNumberInPageNumber
     */
    @Override
    public Page<Product> productList(int pageNumber, String query) throws NotValidNumberInPageNumber {
        if(pageNumber <= 0){
            throw new NotValidNumberInPageNumber("Page number mustn't be 0, or negative number");
        }
        Pageable pageable = PageRequest.of(pageNumber-1, 10); //prwth selida einai h 0 me 10 element
        if(query != null){
            return productRepo.findByQuery(query,pageable);
        }
        return productRepo.findAll(pageable);
    }

    /**
     * Add product in db
     *
     * @param product
     * @return the product which added in database
     * @throws ExistUniqueValueException
     */
    @Override
    public Product addProduct(Product product) throws ObjectNotFoundException, ExistUniqueValueException {
        if(checkIfExistBarCode(product.getBarCode())==true){
            throw new ExistUniqueValueException("This barCode Already exists");
        }
        return productRepo.save(product);
    }

    /**
     * Update product
     *
     * @param product
     * @param productId
     * @return the product which updated
     * @throws ObjectNotFoundException
     * @throws ExistUniqueValueException
     */
    @Override
    public Product updateProduct(Product product, long productId) throws ObjectNotFoundException, ExistUniqueValueException {
        Product productInDb = productRepo.findById(productId)
                .orElseThrow(() -> new ObjectNotFoundException("Product not found"));

        if(checkIfExistBarCode(product.getBarCode())==true){
            throw new ExistUniqueValueException("This barCode Already exists");
        }
        productInDb.setProductName(product.getProductName());
        productInDb.setBarCode(product.getBarCode());
        productInDb.setType(product.getType());

        productRepo.save(productInDb);
        return productInDb;
    }

    /**
     * Delete product by id
     *
     * @param productId
     * @return true if the deletion is successful
     * @throws ObjectNotFoundException
     */
    @Override
    public boolean deleteProduct(long productId) throws ObjectNotFoundException {
        Optional<Product> oProduct = productRepo.findById(productId);
        if (oProduct.isPresent()) { //ean uparxei epistrefei to jobOffer
            productRepo.deleteById(productId);
            return true;
        } else throw new ObjectNotFoundException("Product Not Found");

    }

    /**
     * Check if barCode already exists in the db
     *
     * @param barCode
     * @return true if barCode already exists
     */
    @Override
    public boolean checkIfExistBarCode(String barCode) {
        if(productRepo.findByBarCode(barCode) != null ){
            return true;
        }
        return false;
    }
}

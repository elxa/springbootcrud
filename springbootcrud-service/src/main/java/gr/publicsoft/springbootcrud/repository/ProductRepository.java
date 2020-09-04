package gr.publicsoft.springbootcrud.repository;

import gr.publicsoft.springbootcrud.model.Person;
import gr.publicsoft.springbootcrud.model.Product;
import gr.publicsoft.springbootcrud.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByBarCode(String barCode);

    @Query("SELECT p FROM Product p "
            + "WHERE p.productName LIKE CONCAT('%',?1,'%') "
            + "     OR p.barCode =?1")
    Page<Product> findByQuery(@Param("query") String query, Pageable pageable);

}

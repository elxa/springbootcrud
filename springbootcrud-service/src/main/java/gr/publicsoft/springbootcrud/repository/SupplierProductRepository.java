package gr.publicsoft.springbootcrud.repository;

import gr.publicsoft.springbootcrud.model.SupplierProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource
public interface SupplierProductRepository extends JpaRepository<SupplierProduct, Long> {

    @Query(value = "SELECT * " +
        "FROM Supplier s, Supplierproduct sp, Product p " +
        "WHERE s.id = sp.supplier_id "+
        "AND sp.product_id = p.id "+
        "AND p.barCode = ?1 ", nativeQuery = true)
    Page<SupplierProduct> findByQuery(@Param("query")String query, Pageable pageable);



    @Query(value = "SELECT * " +
            "FROM Supplierproduct sp " +
            "WHERE sp.supplier_id = ?1 "+
            "AND sp.product_id = ?2 ", nativeQuery = true)
    SupplierProduct checkIfExistThisRelation(long supplierId, long productId);
//

}

package gr.publicsoft.springbootcrud.config;

import gr.publicsoft.springbootcrud.model.Person;
import gr.publicsoft.springbootcrud.model.Product;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.model.SupplierProduct;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Person.class, Supplier.class, Product.class, SupplierProduct.class);
    }
}
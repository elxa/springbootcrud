package gr.publicsoft.springbootcrud.services;

import gr.publicsoft.springbootcrud.exception.ObjectNotFoundException;
import gr.publicsoft.springbootcrud.exception.VatNumberException;
import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
public class SupplierServiceImplTest extends TestCase {

    @InjectMocks
    private SupplierService supplierService = new SupplierServiceImpl();
    @Mock
    private SupplierRepository supplierRepo;

    public void testSupplierList() {
//        Supplier s1 = new Supplier(1,"publicSoft", "giorgos", "gewrgiou", "1234567", "ssss", "athinas","10545" ,"athina","greece");
//        Supplier s2 = new Supplier(2,"publicSoft2", "stelios", "steliou", "12344567", "ssss", "8essalonikh","1053345" ,"Thessalonikhs","greece");
//s1.setCompanyName("ddddd");
//        Supplier ss[] = new Supplier[]{s1,s2};
//
//        List<Supplier> suppliers = Arrays.asList(s1);
//        when(supplierRepo.findAll()).thenReturn(suppliers);
//        List<Supplier> suppliersRetrieved = supplierService.supplierList();
//        assertEquals(2,suppliersRetrieved.size());
    }

    public void testGetSupplierById() {
    }

    public void testAddSupplier() {
    }

    public void testUpdateSupplier() {
    }

    public void testDeleteSupplier() {
    }

    public void testCheckIfExistVatNumber() {
    }
}
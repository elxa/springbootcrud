package gr.publicsoft.springbootcrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

import static gr.publicsoft.springbootcrud.Constants.SIZE_M;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"barCode"})})//me auton ton tropo orizw to barCode monadiko mesa sthn bash
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "productName is mandatory")
    @Size(min=3, max = SIZE_M, message = "min 2" )
    @Pattern(regexp="^[a-zA-Z]+$", message = "Product name only characters")
    @Column(nullable = false)
    private String productName;

    @Pattern(regexp="^[a-zA-Z]+$", message = "type only characters")
    @Size(max = SIZE_M)
    private String type;

    @NotBlank(message = "barCode is mandatory")
    @Column(name = "barCode")
    @Size(min = 3, max = SIZE_M)
    private String barCode;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<SupplierProduct> supplierProducts;



}

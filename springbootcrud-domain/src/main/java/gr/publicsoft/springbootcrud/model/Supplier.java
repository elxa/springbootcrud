package gr.publicsoft.springbootcrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

import static gr.publicsoft.springbootcrud.Constants.SIZE_M;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"vatNumber"})})//me auton ton tropo orizw to vatNumber monadiko mesa sthn bash
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "companyName is mandatory")
    @Pattern(regexp="^[a-zA-Z]+$", message = "Company Name only characters")
    @Size(min=3, max = SIZE_M, message = "min 2" )
    @Column(nullable = false)
    private String companyName;

    @Pattern(regexp="^[a-zA-Z]+$", message = "First Name only characters")
    @Size(max = SIZE_M)
    private String firstName;

    @Pattern(regexp="^[a-zA-Z]+$", message = "Last Name only characters")
    @Size(max = SIZE_M)
    private String lastName;

    @NotBlank(message = "vatNumber is mandatory")
    @Pattern(regexp = "^[0-9]*$", message = "Vat Number must be only numbers")
    @Column(name = "vatNumber")
    @Size(max = SIZE_M)
    private String vatNumber;

    @Size(max = SIZE_M)
    private String irsOffice;

    @Size(max = SIZE_M)
    private String address;

   @NotNull(message = "Zip cade not null")
    @Pattern(regexp="^[0-9]*$",message = "ZIP Code must be only numbers")
    @Size(max = SIZE_M)
    private String zipCode;

    @Pattern(regexp="^[a-zA-Z]+$", message = "City only characters")
    @Size(max = SIZE_M)
    private String city;

    @Pattern(regexp="^[a-zA-Z]+$", message = "Country characters")
    @Size(max = SIZE_M)
    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    private List<SupplierProduct> supplierProducts;

}

package gr.publicsoft.springbootcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Pattern(regexp="^[a-zA-Z]+$")
    @Size(min=2, max = SIZE_M, message = "min 2" )
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

    @Pattern(regexp="^[0-9]*$",message = "ZIP Code must be only numbers")
    @Size(max = SIZE_M)
    private String zipCode;

    @Pattern(regexp="^[a-zA-Z]+$", message = "City only characters")
    @Size(max = SIZE_M)
    private String city;

    @Pattern(regexp="^[a-zA-Z]+$", message = "Country characters")
    @Size(max = SIZE_M)
    private String country;

//    public Supplier(long id, String companyName,String firstName, String lastName, String vatNumber, String irsOffice, String address,  String zipCode, String city, String country) {
//        this.id = id;
//        this.companyName = companyName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.vatNumber = vatNumber;
//        this.irsOffice = irsOffice;
//        this.address = address;
//        this.zipCode = zipCode;
//        this.city = city;
//        this.country = country;
//    }
//    public Supplier() {
//    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getCompanyName() {
//        return companyName;
//    }
//
//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getVatNumber() {
//        return vatNumber;
//    }
//
//    public void setVatNumber(String vatNumber) {
//        this.vatNumber = vatNumber;
//    }
//
//    public String getIrsOffice() {
//        return irsOffice;
//    }
//
//    public void setIrsOffice(String irsOffice) {
//        this.irsOffice = irsOffice;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
}

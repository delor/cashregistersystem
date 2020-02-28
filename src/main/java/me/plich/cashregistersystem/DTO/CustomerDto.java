package me.plich.cashregistersystem.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.View;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    private String nip;
    @JsonView(View.Public.class)
    private String regon;
    @JsonView(View.Public.class)
    private String companyName;
    @JsonView(View.Public.class)
    private String telephone;
    @JsonView(View.Public.class)
    private String email;
    @JsonView(View.Public.class)
    private String taxOffice;
    @JsonView(View.Public.class)
    private String description;
    @JsonView(View.Public.class)
    private AddressDto address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", companyName='" + companyName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", taxOffice='" + taxOffice + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                '}';
    }
}

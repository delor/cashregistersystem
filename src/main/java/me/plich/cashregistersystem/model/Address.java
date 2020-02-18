package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(View.Public.class)
    @Column(nullable=true)
    private String street;

    @JsonView(View.Public.class)
    @Column(nullable=false)
    private String houseNumber;

    @JsonView(View.Public.class)
    private String flatNumber;

    @JsonView(View.Public.class)
    @Column(nullable=false)
    private String zipCode;

    @JsonView(View.Public.class)
    @Column(nullable=false)
    private String city;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id) &&
                Objects.equals(street, address.street) &&
                houseNumber.equals(address.houseNumber) &&
                Objects.equals(flatNumber, address.flatNumber) &&
                zipCode.equals(address.zipCode) &&
                city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, houseNumber, flatNumber, zipCode, city);
    }
}

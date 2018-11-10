package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Customer  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    @NotNull
    private String nip;
    @JsonView(View.Public.class)
    @NotNull
    private String name;
    @JsonView(View.Public.class)
    @NotNull
    private String street;
    @JsonView(View.Public.class)
    @NotNull
    private String houseNumber;
    @JsonView(View.Public.class)
    private String flatNumber;
    @JsonView(View.Public.class)
    @NotNull
    private String zipCode;
    @JsonView(View.Public.class)
    @NotNull
    private String place;
    @JsonView(View.Public.class)
    @NotNull
    private String voivodeship;
    @JsonView(View.Public.class)
    @NotNull
    private String telephone;
    @JsonView(View.Public.class)
    private String email;
    @JsonView(View.Public.class)
    @NotNull
    private String taxOffice;
    @JsonView(View.Public.class)
    private String description;
    @ManyToOne
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy="customer")
    private List<Device> devices = new ArrayList<Device>();

    @OneToMany(mappedBy="customer")
    private List<Location> locations = new ArrayList<Location>();

    public Customer(){}

    public Customer(String nip, String name, String street, String houseNumber, String flatNumber, String zipCode, String place, String voivodeship, String telephone, String email, String taxOffice, String description, User user, List<Device> devices, List<Location> locations) {
        this.nip = nip;
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.zipCode = zipCode;
        this.place = place;
        this.voivodeship = voivodeship;
        this.telephone = telephone;
        this.email = email;
        this.taxOffice = taxOffice;
        this.description = description;
        this.user = user;
        this.devices = devices;
        this.locations = locations;
    }

    public Long getId() {
        return id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return houseNumber == customer.houseNumber &&
                flatNumber == customer.flatNumber &&
                telephone == customer.telephone &&
                Objects.equals(id, customer.id) &&
                Objects.equals(nip, customer.nip) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(zipCode, customer.zipCode) &&
                Objects.equals(place, customer.place) &&
                Objects.equals(voivodeship, customer.voivodeship) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(taxOffice, customer.taxOffice) &&
                Objects.equals(description, customer.description) &&
                Objects.equals(user, customer.user) &&
                Objects.equals(devices, customer.devices) &&
                Objects.equals(locations, customer.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nip, name, street, houseNumber, flatNumber, zipCode, place, voivodeship, telephone, email, taxOffice, description, user, devices, locations);
    }
}

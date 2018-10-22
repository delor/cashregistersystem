package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    private Long nip;
    @JsonView(View.Public.class)
    private String name;
    @JsonView(View.Public.class)
    private String street;
    @Nullable
    @JsonView(View.Public.class)
    private Integer houseNumber;
    @JsonView(View.Public.class)
    private Integer flatNumber;
    @JsonView(View.Public.class)
    private String zipCode;
    @JsonView(View.Public.class)
    private String place;
    @JsonView(View.Public.class)
    private String voivodeship;
    @JsonView(View.Public.class)
    private int telephone;
    @JsonView(View.Public.class)
    private String email;
    @JsonView(View.Public.class)
    private String taxOffice;
    @JsonView(View.Public.class)
    private String description;
//    @JsonView(View.Public.class)
//    private Long user_id;
    @ManyToOne
    @JoinColumn(name = "user")
    @JsonIgnore
//    @JsonView(View.Public.class)
    private User user;

    @OneToMany(mappedBy="customer")
    private List<Device> devices = new ArrayList<Device>();

    @OneToMany(mappedBy="customer")
    private List<Location> locations = new ArrayList<Location>();

    public Customer(){}

    public Customer(Long nip, String name, String street, Integer houseNumber, Integer flatNumber, String zipCode, String place, String voivodeship, int telephone, String email, String taxOffice, String description, User user, List<Device> devices, List<Location> locations) {
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
//        this.user_id = user_id;
        this.user = user;
        this.devices = devices;
        this.locations = locations;
    }

    public Long getId() {
        return id;
    }

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
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

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
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

//    public Long getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Long user_id) {
//        this.user_id = user_id;
//    }

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
//                user_id == customer.user_id &&
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

package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    @Column(nullable=false)
    private String name;
    @JsonView(View.Public.class)
    @Column(nullable=false)
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
    private String place;
    @JsonView(View.Public.class)
    @Column(nullable=false)
    private String voivodeship;
    @JsonView(View.Public.class)
    private String telephone;
    @JsonView(View.Public.class)
    private String email;
    @JsonView(View.Public.class)
    private String description;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @JsonIgnore
    @OneToMany(mappedBy="location")
    private List<Device> devices = new ArrayList<Device>();

    public Location(){}

    public Location(String name, String street, String houseNumber, String flatNumber, String zipCode, String place, String voivodeship, String telephone, String email, String description, User user, Customer customer) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.zipCode = zipCode;
        this.place = place;
        this.voivodeship = voivodeship;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
        this.user = user;
        this.customer = customer;
    }

    public Long getId() {
        return id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return houseNumber == location.houseNumber &&
                flatNumber == location.flatNumber &&
                zipCode == location.zipCode &&
                telephone == location.telephone &&
                Objects.equals(id, location.id) &&
                Objects.equals(name, location.name) &&
                Objects.equals(street, location.street) &&
                Objects.equals(place, location.place) &&
                Objects.equals(voivodeship, location.voivodeship) &&
                Objects.equals(email, location.email) &&
                Objects.equals(description, location.description) &&
                Objects.equals(user, location.user) &&
                Objects.equals(customer, location.customer) &&
                Objects.equals(devices, location.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, houseNumber, flatNumber, zipCode, place, voivodeship, telephone, email, description, user, customer, devices);
    }
}

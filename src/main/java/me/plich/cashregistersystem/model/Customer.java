package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer implements IUserChecker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String nip;

    @Column(nullable=true)
    private String regon;
    
    @Column(nullable=false)
    private String companyName;

    @Column(nullable=false)
    private String telephone;
    
    private String email;
    
    @Column(nullable=false)
    private String taxOffice;
    
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Device> devices = new ArrayList<Device>();

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<Location>();

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<Order>();

    public Customer(){}

    public Long getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
                nip.equals(customer.nip) &&
                Objects.equals(regon, customer.regon) &&
                companyName.equals(customer.companyName) &&
                Objects.equals(telephone, customer.telephone) &&
                email.equals(customer.email) &&
                taxOffice.equals(customer.taxOffice) &&
                Objects.equals(description, customer.description) &&
                user.equals(customer.user) &&
                address.equals(customer.address) &&
                Objects.equals(devices, customer.devices) &&
                Objects.equals(locations, customer.locations) &&
                Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nip, regon, companyName, telephone, email, taxOffice, description, user, address, devices, locations, orders);
    }

}

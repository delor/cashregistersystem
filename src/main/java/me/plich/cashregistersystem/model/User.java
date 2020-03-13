package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
@Table(name="users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false, unique = true)
    private String nip;
    @Column(unique = true)
    private String regon;

    @Column(nullable=false, unique = true)
    private String companyName;

    @Column(nullable=false, unique = true)
    private String username;

    private String telephone;

    @Column(nullable=false, unique = true)
    @Email
    private String email;

    @Column(nullable=false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy="user")
    private List<Customer> customers = new ArrayList<Customer>();

    @OneToMany(mappedBy="user")
    private List<Device> devices = new ArrayList<Device>();

    @OneToMany(mappedBy="user")
    private List<Location> locations = new ArrayList<Location>();

    @OneToMany(mappedBy="user")
    private List<Serviceman> servicemens = new ArrayList<Serviceman>();

    @OneToMany(mappedBy="user")
    private List<Order> orders = new ArrayList<Order>();


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    public User(){}

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
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

    public List<Serviceman> getServicemens() {
        return servicemens;
    }

    public void setServicemens(List<Serviceman> servicemens) {
        this.servicemens = servicemens;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                nip.equals(user.nip) &&
                Objects.equals(regon, user.regon) &&
                companyName.equals(user.companyName) &&
                username.equals(user.username) &&
                Objects.equals(telephone, user.telephone) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                roles.equals(user.roles) &&
                Objects.equals(customers, user.customers) &&
                Objects.equals(devices, user.devices) &&
                Objects.equals(locations, user.locations) &&
                Objects.equals(servicemens, user.servicemens) &&
                Objects.equals(orders, user.orders) &&
                address.equals(user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nip, regon, companyName, username, telephone, email, password, roles, customers, devices, locations, servicemens, orders, address);
    }


}
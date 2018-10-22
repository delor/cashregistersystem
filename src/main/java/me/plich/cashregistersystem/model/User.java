package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    private Long nip;
    @JsonView(View.Public.class)
    private String name;
    @JsonView(View.Public.class)
    private String username;
    @JsonView(View.Public.class)
    private String street;
    @JsonView(View.Public.class)
    private int houseNumber;
    @JsonView(View.Public.class)
    private int flatNumber;
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

    public User(){}

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long nip, String username, String street, int houseNumber, int flatNumber, String zipCode, String place, String voivodeship, int telephone, String email, String password) {
        this.nip = nip;
        this.username = username;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.zipCode = zipCode;
        this.place = place;
        this.voivodeship = voivodeship;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
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
        customers = customers;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return houseNumber == user.houseNumber &&
                flatNumber == user.flatNumber &&
                telephone == user.telephone &&
                Objects.equals(id, user.id) &&
                Objects.equals(nip, user.nip) &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(street, user.street) &&
                Objects.equals(zipCode, user.zipCode) &&
                Objects.equals(place, user.place) &&
                Objects.equals(voivodeship, user.voivodeship) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(customers, user.customers) &&
                Objects.equals(devices, user.devices) &&
                Objects.equals(locations, user.locations) &&
                Objects.equals(servicemens, user.servicemens) &&
                Objects.equals(orders, user.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nip, name, username, street, houseNumber, flatNumber, zipCode, place, voivodeship, telephone, email, password, roles, customers, devices, locations, servicemens, orders);
    }
}
package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @Column(nullable=false)
    private String nip;

    @JsonView(View.Public.class)
    @Column(nullable=true)
    private String regon;

    @JsonView(View.Public.class)
    @Column(nullable=false)
    private String name;

    @JsonView(View.Public.class)
    @Column(nullable=false)
    private String username;

    @JsonView(View.Public.class)
    private String telephone;

    @JsonView(View.Public.class)
    @Column(nullable=false)
    @Email
    private String email;

    @JsonView(View.Public.class)
    @Column(nullable=false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @JsonView(View.Public.class)
    @OneToMany(mappedBy="user")
    private List<Customer> customers = new ArrayList<Customer>();
    @JsonView(View.Public.class)
    @OneToMany(mappedBy="user")
    private List<Device> devices = new ArrayList<Device>();
    @JsonView(View.Public.class)
    @OneToMany(mappedBy="user")
    private List<Location> locations = new ArrayList<Location>();
    @JsonView(View.Public.class)
    @OneToMany(mappedBy="user")
    private List<Serviceman> servicemens = new ArrayList<Serviceman>();
    @JsonView(View.Public.class)
    @OneToMany(mappedBy="user")
    private List<Order> orders = new ArrayList<Order>();

    @JsonView(View.Public.class)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                name.equals(user.name) &&
                username.equals(user.username) &&
                Objects.equals(telephone, user.telephone) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(customers, user.customers) &&
                Objects.equals(devices, user.devices) &&
                Objects.equals(locations, user.locations) &&
                Objects.equals(servicemens, user.servicemens) &&
                Objects.equals(orders, user.orders) &&
                address.equals(user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nip, regon, name, username, telephone, email, password, roles, customers, devices, locations, servicemens, orders, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", customers=" + customers +
                ", devices=" + devices +
                ", locations=" + locations +
                ", servicemens=" + servicemens +
                ", orders=" + orders +
                ", address=" + address +
                '}';
    }
}
package me.plich.cashregistersystem.DTO;


import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.View;

public class UserDto {
    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    private String nip;
    @JsonView(View.Public.class)
    private String regon;
    @JsonView(View.Public.class)
    private String name;
    @JsonView(View.Public.class)
    private String username;
    @JsonView(View.Public.class)
    private String telephone;
    @JsonView(View.Public.class)
    private String email;
    private String password;
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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}

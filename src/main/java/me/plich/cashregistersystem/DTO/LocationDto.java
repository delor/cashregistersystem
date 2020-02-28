package me.plich.cashregistersystem.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDto {

    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    private String name;
    @JsonView(View.Public.class)
    private String telephone;
    @JsonView(View.Public.class)
    private String email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "LocationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                '}';
    }
}

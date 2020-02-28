package me.plich.cashregistersystem.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.View;

import javax.persistence.Column;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServicemanDto {

    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    private String firstName;
    @JsonView(View.Public.class)
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ServicemanDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

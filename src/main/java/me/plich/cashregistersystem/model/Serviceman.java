package me.plich.cashregistersystem.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "servicemens")
public class Serviceman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String firstName;
    
    @Column(nullable=false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Serviceman(){}

    public Long getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serviceman that = (Serviceman) o;
        return id.equals(that.id) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, user);
    }

    @Override
    public String toString() {
        return "Serviceman{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", user=" + user +
                '}';
    }
}

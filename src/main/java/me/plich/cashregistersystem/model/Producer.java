package me.plich.cashregistersystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "producers")
public class Producer {
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

    @Column(nullable=false)
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy="producer")
    private List<Device> devices = new ArrayList<Device>();

    public Producer() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return id.equals(producer.id) &&
                nip.equals(producer.nip) &&
                Objects.equals(regon, producer.regon) &&
                companyName.equals(producer.companyName) &&
                Objects.equals(telephone, producer.telephone) &&
                email.equals(producer.email) &&
                address.equals(producer.address) &&
                Objects.equals(devices, producer.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nip, regon, companyName, telephone, email, address, devices);
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", companyName='" + companyName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", devices=" + devices +
                '}';
    }
}

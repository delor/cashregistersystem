package me.plich.cashregistersystem.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "devices")
public class Device implements IUserChecker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(nullable=false)
    private String uniqueNumber;
   
    @Column(nullable=false)
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    private LocalDate dateOfFiscalization;

    private LocalDate dateOfDeRegistration;
   
    private String evidenceNumber;
   
    @Column(nullable=false)
    private int reviewsFrequency;

    private LocalDate lastReview;

    private LocalDate plannedReview;
   
    private int dailyReports;
   
    private Boolean active;

    private Boolean mobile;
   
    private Boolean reserve;
   
    private String description;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy="device")
    private List<Order> orders = new ArrayList<Order>();

    public Device(){}

    public Long getId() {
        return id;
    }


    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public LocalDate getDateOfFiscalization() {
        return dateOfFiscalization;
    }

    public void setDateOfFiscalization(LocalDate dateOfFiscalization) {
        this.dateOfFiscalization = dateOfFiscalization;
    }

    public LocalDate getDateOfDeRegistration() {
        return dateOfDeRegistration;
    }

    public void setDateOfDeRegistration(LocalDate dateOfDeRegistration) {
        this.dateOfDeRegistration = dateOfDeRegistration;
    }

    public String getEvidenceNumber() {
        return evidenceNumber;
    }

    public void setEvidenceNumber(String evidenceNumber) {
        this.evidenceNumber = evidenceNumber;
    }

    public int getReviewsFrequency() {
        return reviewsFrequency;
    }

    public void setReviewsFrequency(int reviewsFrequency) {
        this.reviewsFrequency = reviewsFrequency;
    }

    public LocalDate getLastReview() {
        return lastReview;
    }

    public void setLastReview(LocalDate lastReview) {
        this.lastReview = lastReview;
    }

    public LocalDate getPlannedReview() {
        return plannedReview;
    }

    public void setPlannedReview(LocalDate plannedReview) {
        this.plannedReview = plannedReview;
    }

    public int getDailyReports() {
        return dailyReports;
    }

    public void setDailyReports(int dailyReports) {
        this.dailyReports = dailyReports;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

    public Boolean getReserve() {
        return reserve;
    }

    public void setReserve(Boolean reserve) {
        this.reserve = reserve;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
        Device device = (Device) o;
        return reviewsFrequency == device.reviewsFrequency &&
                dailyReports == device.dailyReports &&
                id.equals(device.id) &&
                uniqueNumber.equals(device.uniqueNumber) &&
                serialNumber.equals(device.serialNumber) &&
                producer.equals(device.producer) &&
                model.equals(device.model) &&
                Objects.equals(dateOfFiscalization, device.dateOfFiscalization) &&
                Objects.equals(dateOfDeRegistration, device.dateOfDeRegistration) &&
                Objects.equals(evidenceNumber, device.evidenceNumber) &&
                Objects.equals(lastReview, device.lastReview) &&
                Objects.equals(plannedReview, device.plannedReview) &&
                Objects.equals(active, device.active) &&
                Objects.equals(mobile, device.mobile) &&
                Objects.equals(reserve, device.reserve) &&
                Objects.equals(description, device.description) &&
                Objects.equals(location, device.location) &&
                user.equals(device.user) &&
                customer.equals(device.customer) &&
                Objects.equals(orders, device.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uniqueNumber, serialNumber, producer, model, dateOfFiscalization, dateOfDeRegistration, evidenceNumber, reviewsFrequency, lastReview, plannedReview, dailyReports, active, mobile, reserve, description, location, user, customer, orders);
    }

}

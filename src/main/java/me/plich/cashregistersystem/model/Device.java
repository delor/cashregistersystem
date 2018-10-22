package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    private String uniqueNumber;
    @JsonView(View.Public.class)
    private String serialNumber;
    @JsonView(View.Public.class)
    private Producer producer;
    @JsonView(View.Public.class)
    private Model model;
    private LocalDate saleDate;
    private LocalDate dateOfFiscalization;
    private LocalDate dateOfDeRegistration;
    @JsonView(View.Public.class)
    private String evidenceNumber;
    @JsonView(View.Public.class)
    private int reviewsFrequency;
    private LocalDate lastReview;
    private LocalDate plannedReview;
    @JsonView(View.Public.class)
    private int dailyReports;
    @JsonView(View.Public.class)
    private Boolean active;
    @JsonView(View.Public.class)
    private Boolean mobile;
    @JsonView(View.Public.class)
    private Boolean reserve;
    @JsonView(View.Public.class)
    private String description;
    @ManyToOne
    @JsonView(View.Public.class)
    @JoinColumn(name = "location_id")
    private Location location;
    @ManyToOne
    @JsonView(View.Public.class)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JsonView(View.Public.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @JsonView(View.Public.class)
    @OneToMany(mappedBy="device")
    private List<Order> orders = new ArrayList<Order>();

    public Device(){}

    public Device(String uniqueNumber, String serialNumber, Producer producer, Model model, LocalDate saleDate, int reviewsFrequency, String description, Location location, User user, Customer customer) {
        this.uniqueNumber = uniqueNumber;
        this.serialNumber = serialNumber;
        this.producer = producer;
        this.model = model;
        this.saleDate = saleDate;
        this.reviewsFrequency = reviewsFrequency;
        this.description = description;
        this.location = location;
        this.user = user;
        this.customer = customer;
    }

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

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
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
                Objects.equals(id, device.id) &&
                Objects.equals(uniqueNumber, device.uniqueNumber) &&
                Objects.equals(serialNumber, device.serialNumber) &&
                producer == device.producer &&
                model == device.model &&
                Objects.equals(saleDate, device.saleDate) &&
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
                Objects.equals(user, device.user) &&
                Objects.equals(customer, device.customer) &&
                Objects.equals(orders, device.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uniqueNumber, serialNumber, producer, model, saleDate, dateOfFiscalization, dateOfDeRegistration, evidenceNumber, reviewsFrequency, lastReview, plannedReview, dailyReports, active, mobile, reserve, description, location, user, customer, orders);
    }
}

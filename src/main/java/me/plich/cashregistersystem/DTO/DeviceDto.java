package me.plich.cashregistersystem.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.*;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceDto {

    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    private String uniqueNumber;
    @JsonView(View.Public.class)
    private String serialNumber;
    @JsonView(View.Public.class)
    private ProducerDto producer;
    @JsonView(View.Public.class)
    private ModelDto model;
    @JsonView(View.Public.class)
    private LocalDate dateOfFiscalization;
    @JsonView(View.Public.class)
    private LocalDate dateOfDeRegistration;
    @JsonView(View.Public.class)
    private String evidenceNumber;
    @JsonView(View.Public.class)
    private int reviewsFrequency;
    @JsonView(View.Public.class)
    private LocalDate lastReview;
    @JsonView(View.Public.class)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProducerDto getProducer() {
        return producer;
    }

    public void setProducer(ProducerDto producer) {
        this.producer = producer;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
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

    @Override
    public String toString() {
        return "DeviceDto{" +
                "id=" + id +
                ", uniqueNumber='" + uniqueNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", producer=" + producer +
                ", model='" + model + '\'' +
                ", dateOfFiscalization=" + dateOfFiscalization +
                ", dateOfDeRegistration=" + dateOfDeRegistration +
                ", evidenceNumber='" + evidenceNumber + '\'' +
                ", reviewsFrequency=" + reviewsFrequency +
                ", lastReview=" + lastReview +
                ", plannedReview=" + plannedReview +
                ", dailyReports=" + dailyReports +
                ", active=" + active +
                ", mobile=" + mobile +
                ", reserve=" + reserve +
                ", description='" + description + '\'' +
                '}';
    }
}

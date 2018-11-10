package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonView;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    @NotNull
    private OrderType orderType;
    @JsonView(View.Public.class)
    @NotNull
    private LocalDate orderDate;
    @JsonView(View.Public.class)
    @NotNull
    private StateOfSeals seals;
    private String generalCounterFrom;
    private String generalCounterTo;
    private String dailyReportFrom;
    private String dailyReportTo;
    private String resettingFramesFrom;
    private String resettingFramesTo;
    private String receiptFrom;
    private String receiptTo;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public Order(){}

    public Order(OrderType orderType, LocalDate orderDate, StateOfSeals seals, String generalCounterFrom, String generalCounterTo, String dailyReportFrom, String dailyReportTo, String resettingFramesFrom, String resettingFramesTo, String receiptFrom, String receiptTo, User user, Device device) {
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.seals = seals;
        this.generalCounterFrom = generalCounterFrom;
        this.generalCounterTo = generalCounterTo;
        this.dailyReportFrom = dailyReportFrom;
        this.dailyReportTo = dailyReportTo;
        this.resettingFramesFrom = resettingFramesFrom;
        this.resettingFramesTo = resettingFramesTo;
        this.receiptFrom = receiptFrom;
        this.receiptTo = receiptTo;
        this.user = user;
        this.device = device;
    }

    public Long getId() {
        return id;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public StateOfSeals getSeals() {
        return seals;
    }

    public void setSeals(StateOfSeals seals) {
        this.seals = seals;
    }

    public String getGeneralCounterFrom() {
        return generalCounterFrom;
    }

    public void setGeneralCounterFrom(String generalCounterFrom) {
        this.generalCounterFrom = generalCounterFrom;
    }

    public String getGeneralCounterTo() {
        return generalCounterTo;
    }

    public void setGeneralCounterTo(String generalCounterTo) {
        this.generalCounterTo = generalCounterTo;
    }

    public String getDailyReportFrom() {
        return dailyReportFrom;
    }

    public void setDailyReportFrom(String dailyReportFrom) {
        this.dailyReportFrom = dailyReportFrom;
    }

    public String getDailyReportTo() {
        return dailyReportTo;
    }

    public void setDailyReportTo(String dailyReportTo) {
        this.dailyReportTo = dailyReportTo;
    }

    public String getResettingFramesFrom() {
        return resettingFramesFrom;
    }

    public void setResettingFramesFrom(String resettingFramesFrom) {
        this.resettingFramesFrom = resettingFramesFrom;
    }

    public String getResettingFramesTo() {
        return resettingFramesTo;
    }

    public void setResettingFramesTo(String resettingFramesTo) {
        this.resettingFramesTo = resettingFramesTo;
    }

    public String getReceiptFrom() {
        return receiptFrom;
    }

    public void setReceiptFrom(String receiptFrom) {
        this.receiptFrom = receiptFrom;
    }

    public String getReceiptTo() {
        return receiptTo;
    }

    public void setReceiptTo(String receiptTo) {
        this.receiptTo = receiptTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return generalCounterFrom == order.generalCounterFrom &&
                generalCounterTo == order.generalCounterTo &&
                dailyReportFrom == order.dailyReportFrom &&
                dailyReportTo == order.dailyReportTo &&
                resettingFramesFrom == order.resettingFramesFrom &&
                resettingFramesTo == order.resettingFramesTo &&
                receiptFrom == order.receiptFrom &&
                receiptTo == order.receiptTo &&
                Objects.equals(id, order.id) &&
                orderType == order.orderType &&
                Objects.equals(orderDate, order.orderDate) &&
                seals == order.seals &&
                Objects.equals(user, order.user) &&
                Objects.equals(device, order.device);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderType, orderDate, seals, generalCounterFrom, generalCounterTo, dailyReportFrom, dailyReportTo, resettingFramesFrom, resettingFramesTo, receiptFrom, receiptTo, user, device);
    }
}

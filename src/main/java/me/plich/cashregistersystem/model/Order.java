package me.plich.cashregistersystem.model;

import com.fasterxml.jackson.annotation.JsonView;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    @Column(nullable=false)
    private OrderType orderType;
    @JsonView(View.Public.class)
    @Column(nullable=false)
    private LocalDate orderDate;
    @JsonView(View.Public.class)
    @Column(nullable=false)
    private StateOfSeals seals;
    private Integer generalCounterFrom;
    private Integer generalCounterTo;
    private Integer dailyReportFrom;
    private Integer dailyReportTo;
    private Integer resettingFramesFrom;
    private Integer resettingFramesTo;
    private Integer receiptFrom;
    private Integer receiptTo;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "device_id")
    @JsonView(View.Public.class)
    private Device device;

    public Order(){}

    public Order(OrderType orderType, LocalDate orderDate, StateOfSeals seals, Integer generalCounterFrom, Integer generalCounterTo, Integer dailyReportFrom, Integer dailyReportTo, Integer resettingFramesFrom, Integer resettingFramesTo, Integer receiptFrom,  Integer receiptTo, User user, Device device) {
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

    public Integer getGeneralCounterFrom() {
        return generalCounterFrom;
    }

    public void setGeneralCounterFrom(Integer generalCounterFrom) {
        this.generalCounterFrom = generalCounterFrom;
    }

    public Integer getGeneralCounterTo() {
        return generalCounterTo;
    }

    public void setGeneralCounterTo(Integer generalCounterTo) {
        this.generalCounterTo = generalCounterTo;
    }

    public Integer getDailyReportFrom() {
        return dailyReportFrom;
    }

    public void setDailyReportFrom(Integer dailyReportFrom) {
        this.dailyReportFrom = dailyReportFrom;
    }

    public Integer getDailyReportTo() {
        return dailyReportTo;
    }

    public void setDailyReportTo(Integer dailyReportTo) {
        this.dailyReportTo = dailyReportTo;
    }

    public Integer getResettingFramesFrom() {
        return resettingFramesFrom;
    }

    public void setResettingFramesFrom(Integer resettingFramesFrom) {
        this.resettingFramesFrom = resettingFramesFrom;
    }

    public Integer getResettingFramesTo() {
        return resettingFramesTo;
    }

    public void setResettingFramesTo(Integer resettingFramesTo) {
        this.resettingFramesTo = resettingFramesTo;
    }

    public Integer getReceiptFrom() {
        return receiptFrom;
    }

    public void setReceiptFrom(Integer receiptFrom) {
        this.receiptFrom = receiptFrom;
    }

    public Integer getReceiptTo() {
        return receiptTo;
    }

    public void setReceiptTo(Integer receiptTo) {
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
        return Objects.equals(id, order.id) &&
                orderType == order.orderType &&
                Objects.equals(orderDate, order.orderDate) &&
                seals == order.seals &&
                Objects.equals(generalCounterFrom, order.generalCounterFrom) &&
                Objects.equals(generalCounterTo, order.generalCounterTo) &&
                Objects.equals(dailyReportFrom, order.dailyReportFrom) &&
                Objects.equals(dailyReportTo, order.dailyReportTo) &&
                Objects.equals(resettingFramesFrom, order.resettingFramesFrom) &&
                Objects.equals(resettingFramesTo, order.resettingFramesTo) &&
                Objects.equals(receiptFrom, order.receiptFrom) &&
                Objects.equals(receiptTo, order.receiptTo) &&
                Objects.equals(user, order.user) &&
                Objects.equals(device, order.device);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderType, orderDate, seals, generalCounterFrom, generalCounterTo, dailyReportFrom, dailyReportTo, resettingFramesFrom, resettingFramesTo, receiptFrom, receiptTo, user, device);
    }
}

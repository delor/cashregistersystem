package me.plich.cashregistersystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OrderType orderType;
    private LocalDate orderDate;
    private StateOfSeals seals;
    private int generalCounterFrom;
    private int generalCounterTo;
    private int dailyReportFrom;
    private int dailyReportTo;
    private int resettingFramesFrom;
    private int resettingFramesTo;
    private int receiptFrom;
    private int receiptTo;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public Order(){}

    public Order(OrderType orderType, LocalDate orderDate, StateOfSeals seals, int generalCounterFrom, int generalCounterTo, int dailyReportFrom, int dailyReportTo, int resettingFramesFrom, int resettingFramesTo, int receiptFrom, int receiptTo, User user, Device device) {
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

    public int getGeneralCounterFrom() {
        return generalCounterFrom;
    }

    public void setGeneralCounterFrom(int generalCounterFrom) {
        this.generalCounterFrom = generalCounterFrom;
    }

    public int getGeneralCounterTo() {
        return generalCounterTo;
    }

    public void setGeneralCounterTo(int generalCounterTo) {
        this.generalCounterTo = generalCounterTo;
    }

    public int getDailyReportFrom() {
        return dailyReportFrom;
    }

    public void setDailyReportFrom(int dailyReportFrom) {
        this.dailyReportFrom = dailyReportFrom;
    }

    public int getDailyReportTo() {
        return dailyReportTo;
    }

    public void setDailyReportTo(int dailyReportTo) {
        this.dailyReportTo = dailyReportTo;
    }

    public int getResettingFramesFrom() {
        return resettingFramesFrom;
    }

    public void setResettingFramesFrom(int resettingFramesFrom) {
        this.resettingFramesFrom = resettingFramesFrom;
    }

    public int getResettingFramesTo() {
        return resettingFramesTo;
    }

    public void setResettingFramesTo(int resettingFramesTo) {
        this.resettingFramesTo = resettingFramesTo;
    }

    public int getReceiptFrom() {
        return receiptFrom;
    }

    public void setReceiptFrom(int receiptFrom) {
        this.receiptFrom = receiptFrom;
    }

    public int getReceiptTo() {
        return receiptTo;
    }

    public void setReceiptTo(int receiptTo) {
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

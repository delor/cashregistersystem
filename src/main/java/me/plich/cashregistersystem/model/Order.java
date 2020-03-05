package me.plich.cashregistersystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements IUserChecker{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private OrderType orderType;

    @Column(nullable=false)
    private LocalDate orderDate;

    @Column(nullable=false)
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(){}

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                orderType == order.orderType &&
                orderDate.equals(order.orderDate) &&
                seals == order.seals &&
                Objects.equals(generalCounterFrom, order.generalCounterFrom) &&
                Objects.equals(generalCounterTo, order.generalCounterTo) &&
                Objects.equals(dailyReportFrom, order.dailyReportFrom) &&
                Objects.equals(dailyReportTo, order.dailyReportTo) &&
                Objects.equals(resettingFramesFrom, order.resettingFramesFrom) &&
                Objects.equals(resettingFramesTo, order.resettingFramesTo) &&
                Objects.equals(receiptFrom, order.receiptFrom) &&
                Objects.equals(receiptTo, order.receiptTo) &&
                user.equals(order.user) &&
                device.equals(order.device) &&
                customer.equals(order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderType, orderDate, seals, generalCounterFrom, generalCounterTo, dailyReportFrom, dailyReportTo, resettingFramesFrom, resettingFramesTo, receiptFrom, receiptTo, user, device, customer);
    }
}

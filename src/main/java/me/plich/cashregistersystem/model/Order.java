package me.plich.cashregistersystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

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

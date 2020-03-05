package me.plich.cashregistersystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.OrderType;
import me.plich.cashregistersystem.model.StateOfSeals;
import me.plich.cashregistersystem.model.View;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

    @JsonView(View.Public.class)
    private Long id;
    @JsonView(View.Public.class)
    private OrderType orderType;
    @JsonView(View.Public.class)
    private LocalDate orderDate;
    @JsonView(View.Public.class)
    private StateOfSeals seals;
    @JsonView(View.Public.class)
    private int generalCounterFrom;
    @JsonView(View.Public.class)
    private int generalCounterTo;
    @JsonView(View.Public.class)
    private int dailyReportFrom;
    @JsonView(View.Public.class)
    private int dailyReportTo;
    @JsonView(View.Public.class)
    private int resettingFramesFrom;
    @JsonView(View.Public.class)
    private int resettingFramesTo;
    @JsonView(View.Public.class)
    private int receiptFrom;
    @JsonView(View.Public.class)
    private int receiptTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", orderType=" + orderType +
                ", orderDate=" + orderDate +
                ", seals=" + seals +
                ", generalCounterFrom=" + generalCounterFrom +
                ", generalCounterTo=" + generalCounterTo +
                ", dailyReportFrom=" + dailyReportFrom +
                ", dailyReportTo=" + dailyReportTo +
                ", resettingFramesFrom=" + resettingFramesFrom +
                ", resettingFramesTo=" + resettingFramesTo +
                ", receiptFrom=" + receiptFrom +
                ", receiptTo=" + receiptTo +
                '}';
    }
}

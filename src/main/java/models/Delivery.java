package models;

import java.util.Date;

public class Delivery {
    private int deliveryId;
    private int courierId;
    private int customerId;
    private java.sql.Timestamp deliveryDate;
    private String status;

    public int getId() {
        return deliveryId;
    }

    public void setId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public java.sql.Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(java.sql.Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

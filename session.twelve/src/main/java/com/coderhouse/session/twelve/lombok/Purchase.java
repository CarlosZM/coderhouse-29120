package com.coderhouse.session.twelve.lombok;

import java.util.Objects;

public class Purchase {

    private String id;

    private String sellerId;

    private String clientId;

    private String totalAmount;

    private String status;

    private String purchaseNumber;

    public Purchase(String id, String sellerId, String clientId, String totalAmount, String status, String purchaseNumber) {
        this.id = id;
        this.sellerId = sellerId;
        this.clientId = clientId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.purchaseNumber = purchaseNumber;
    }

    public Purchase() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id) && Objects.equals(sellerId, purchase.sellerId) && Objects.equals(clientId, purchase.clientId) && Objects.equals(totalAmount, purchase.totalAmount) && Objects.equals(status, purchase.status) && Objects.equals(purchaseNumber, purchase.purchaseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sellerId, clientId, totalAmount, status, purchaseNumber);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", status='" + status + '\'' +
                ", purchaseNumber='" + purchaseNumber + '\'' +
                '}';
    }
}

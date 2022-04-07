package com.coderhouse.session.twelve.mapstruct;

import java.util.Objects;

public class PurchaseDto {

    private String id;

    private String seller;

    private String clientId;

    private String totalAmount;

    private String status;

    private String purchaseNumber;

    public PurchaseDto(String id, String seller, String clientId, String totalAmount, String status, String purchaseNumber) {
        this.id = id;
        this.seller = seller;
        this.clientId = clientId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.purchaseNumber = purchaseNumber;
    }

    public PurchaseDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
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
        PurchaseDto purchase = (PurchaseDto) o;
        return Objects.equals(id, purchase.id) && Objects.equals(seller, purchase.seller) && Objects.equals(clientId, purchase.clientId) && Objects.equals(totalAmount, purchase.totalAmount) && Objects.equals(status, purchase.status) && Objects.equals(purchaseNumber, purchase.purchaseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seller, clientId, totalAmount, status, purchaseNumber);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", sellerId='" + seller + '\'' +
                ", clientId='" + clientId + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", status='" + status + '\'' +
                ", purchaseNumber='" + purchaseNumber + '\'' +
                '}';
    }
}

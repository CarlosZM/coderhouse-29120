package com.coderhouse.session.eight.plainv2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tlb_transaction")
public class Transaction implements BusinessBehaviour<Transaction, Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String orientation;

    private Double amount;

    private Boolean enabled;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Transaction(Integer id, String orientation, Double amount) {
        this.id = id;
        this.orientation = orientation;
        this.amount = amount;
    }

    public Transaction() {
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getOrientation() {
        return orientation;
    }

    public Double getAmount() {
        return amount;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void doCreation() {
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public void voidUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public Transaction copyFrom(Transaction source) {

        this.amount = source.amount;

        return this;
    }

    @Override
    public void updateFieldsForDelete() {
        this.enabled = false;
    }
}

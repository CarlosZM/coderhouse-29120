package com.coderhouse.session.eight.plainv2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tlb_bank")
public class Bank implements BusinessBehaviour<Bank, Integer> {

    @Id
    private Integer id;

    private String name;

    private Boolean enabled;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Bank(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Bank() {
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void doCreation() {
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public void voidUpdate() {
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public Bank copyFrom(Bank source) {

        this.name = source.name;

        return this;
    }

    @Override
    public void updateFieldsForDelete() {
        this.enabled = false;
    }
}

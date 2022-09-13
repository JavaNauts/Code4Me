package com.javanauts.code4me.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class clientUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private ArrayList<String> receipts;

    protected clientUser() {
    }

    public clientUser(ArrayList<String> receipts) {
        this.receipts = receipts;
    }

    public Long getId() {
        return id;
    }


    public ArrayList<String> getReceipts() {
        return receipts;
    }

    public void setReceipts(ArrayList<String> receipts) {
        this.receipts = receipts;
    }
}

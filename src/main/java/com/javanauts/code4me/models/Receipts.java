package com.javanauts.code4me.models;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Receipts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private ArrayList<String> receipts;

    @ManyToOne
    AppUser appUser;

    protected Receipts(){
    }

    public Receipts(ArrayList<String> receipts){
        this.receipts = receipts;
    }

    public ArrayList<String> getReceipts() {
        return receipts;
    }

    public void setReceipts(ArrayList<String> receipts) {
        this.receipts = receipts;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}

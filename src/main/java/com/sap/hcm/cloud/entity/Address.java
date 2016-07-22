package com.sap.hcm.cloud.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity  
public class Address implements Serializable {  
    private static final long serialVersionUID = 1L;  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;  
    private String name;  
    private String description;  
    private String zipcode;  
    @ManyToOne  
    private Customer customer;  
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String getDescription() {  
        return description;  
    }  
    public void setDescription(String description) {  
        this.description = description;  
    }  
    public String getZipcode() {  
        return zipcode;  
    }  
    public void setZipcode(String zipcode) {  
        this.zipcode = zipcode;  
    }  
    @ManyToOne  
    public Customer getCustomer() {  
        return customer;  
    }  
    public void setCustomer(Customer customer) {  
        this.customer = customer;  
    }  
    @Override  
    public String toString() {  
        return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);  
    }  
}  

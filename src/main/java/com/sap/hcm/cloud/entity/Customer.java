package com.sap.hcm.cloud.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity  
public class Customer implements Serializable {  
    private static final long serialVersionUID = 1L;  
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;  
    private String name;  
    private String email;  
    @Temporal(TemporalType.DATE)  
    private Date birthday;  
    @OneToMany(mappedBy = "customer")  
    private final List<Address> addresses = new ArrayList<Address>();  
      
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
    public String getEmail() {  
        return email;  
    }  
    public void setEmail(String email) {  
        this.email = email;  
    }  
    public Date getBirthday() {  
        return birthday;  
    }  
    public void setBirthday(Date birthday) {  
        this.birthday = birthday;  
    }  
    public List<Address> getAddresses() {  
        return addresses;  
    }  
    public void addAddress(Address address) {  
        this.addresses.add(address);  
        address.setCustomer(this);  
    }  
    @Override  
    public String toString() {  
        return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);  
    }  
}  
package com.example.orderservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders") 
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer oid;
    String oname;
    String status;
    Integer uid;

    public Integer getOid() {
        return oid;
    }
    public void setOid(Integer oid) {
        this.oid = oid;
    }
    public String getOname() {
        return oname;
    }
    public void setOname(String oname) {
        this.oname = oname;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Order() {
    }

    
}

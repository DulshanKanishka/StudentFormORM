/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sandaru Chamod
 */
@Entity
@Table(name = "Student")
public class Student {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sid;
    private String sName;
    private String address;
    private String tel;
    
    public Student(){}

    public Student(String sName, String address, String tel) {
        this.sName = sName;
        this.address = address;
        this.tel = tel;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", sName=" + sName + ", address=" + address + ", tel=" + tel + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.komet.kometsalesmvc.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Gaston Trujillo
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable{
    
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(name = "user_dni",unique = true, nullable = false)
    private String dni;
    @Column(name = "user_first_name")
    private String firstname;
    @Column(name = "user_last_name", nullable = false)
    private String lastname;
    @Column(name = "user_birth_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthdate;
    @Column(name = "user_email", unique = true)
    private String email;
    @Column(name = "user_phone", unique = true)
    private String phone;
    @Column(name = "user_password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
        
    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append("dni : ").append(getDni());
        strBuff.append(", firstname : ").append(getFirstname());
        strBuff.append(", lastname : ").append(getLastname());
        return strBuff.toString();
    }
    
    
    
}

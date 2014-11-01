/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.komet.kometsalesmvc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.komet.kometsalesmvc.model.User;
import com.komet.kometsalesmvc.services.DataService;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Gaston Trujillo
 */

public class UserManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    //Spring Customer Service is injected...
    DataService dataService;

    List<User> userList;

    private Integer id;
    private String dni;
    private String firstname;
    private String lastname;
    private String email;
    private Date birthdate;
    private String phone;
    private String password;

    /**
     * Add User
     *
     * @return String - Response Message
     */
    public String addUser() {
        try {
            User user = new User();
            user.setId(getId());
            user.setDni(getDni());
            user.setFirstname(getFirstname());
            user.setLastname(getLastname());
            user.setBirthdate(getBirthdate());
            user.setEmail(getEmail());
            user.setPhone(getPhone());
            user.setPassword(getPassword());
            getDataService().addUser(user);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    /**
     * Reset Fields
     *
     */
    public void reset() {
        this.setId(0);
        this.setDni("");
        this.setFirstname("");
        this.setLastname("");
        this.setBirthdate(new Date());
        this.setEmail("");
        this.setPhone("");
        this.setPassword("");

    }

    /**
     * Get User List
     *
     * @return List - User List
     */
    public List<User> getUserList() {
        userList = new ArrayList<User>();
        userList.addAll(getDataService().getUsers());
        return userList;
    }

    /**
     * Get User Service
     *
     * @return DataServices - User Service
     */
    public DataService getDataService() {
        return dataService;
    }

    /**
     * Set Data Service
     *
     * @param dataService DataServices - User Service
     */
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    /**
     * Set User List
     *
     * @param userList List - User List
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * Get User Id
     *
     * @return Integer - User Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set User Id
     *
     * @param id Integer - User Id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
        /**
     * Get User Dni
     *
     * @return String - User Dni
     */
    public String getDni() {
        return dni;
    }
    
            /**
     * Set User Dni
     *
     * @param dni - User Dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Get User Firstname
     *
     * @return String - User Firstname
     */
    public String getFirstname() {
        return firstname;
    }
    
    
   /**
     * Set User Firstname
     *
     * @param firstname - User Firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
        /**
     * Get User Lastname
     *
     * @return String - User Lastname
     */
    public String getLastname() {
        return lastname;
    }
    
    
   /**
     * Set User Lastname
     *
     * @param lastname - User Lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    /**
     * Get User Birthdate
     *
     * @return Date - User Birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Set User Birthdate
     *
     * @param birthdate Date - User Birthdate
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    /**
     * Get User Email
     *
     * @return String - User Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set User Email
     *
     * @param email String - User Email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Get User Phone
     *
     * @return String - User Phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set User Phone
     *
     * @param phone String - User Phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * Get User Password
     *
     * @return String - User Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set User Password
     *
     * @param password String - User Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}

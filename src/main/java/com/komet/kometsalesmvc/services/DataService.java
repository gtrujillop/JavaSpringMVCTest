/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.komet.kometsalesmvc.services;

/**
 *
 * @author Gaston Trujillo
 */
import java.util.List;  
import com.komet.kometsalesmvc.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.komet.kometsalesmvc.model.User;


/**
 *
 * @author Gaston Trujillo
 */

@Service("UserService")
@Transactional(readOnly = false)
public class DataService {

    // CustomerDAO is injected...
    @Autowired
    UserDAO userDAO;

    /**
     * Add User
     *
     * @param  user User
     */
    @Transactional(readOnly = false)
    public void addUser(User user) {
        getUserDAO().addUser(user);
    }

    /**
     * Delete User
     *
     * @param   user  User
     */
    @Transactional(readOnly = false)
    public void deleteUser(User user) {
        getUserDAO().deleteUser(user);
    }

    /**
     * Update User
     *
     * @param user  User
     */
    @Transactional(readOnly = false)
    public void updateUser(User user) {
        getUserDAO().updateUser(user);
    }

    /**
     * Get User
     *
     * @param  id Integer User Id
     */

    public User getUserById(Integer id) {
        return getUserDAO().getUserById(id);
    }

    /**
     * Get User List
     *
     */

    public List<User> getUsers() {
        return getUserDAO().getUsers();
    }

    /**
     * Get User DAO
     *
     * @return userDAO - User DAO
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Set User DAO
     *
     * @param  userDAO - UserDAO
     */
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

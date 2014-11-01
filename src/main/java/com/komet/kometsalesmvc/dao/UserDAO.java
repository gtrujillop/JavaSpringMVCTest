/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.komet.kometsalesmvc.dao;

import java.util.List;
import com.komet.kometsalesmvc.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gaston Trujillo
 * 
 */
@Repository
public class UserDAO  {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Get Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Set Hibernate Session Factory
     *
     * @param sessionFactory SessionFactory - Hibernate Session Factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Add user
     *
     * @param   user   user
     */

    public void addUser(User user) {
        getSessionFactory().getCurrentSession().save(user);
    }

    /**
     * Delete user
     *
     * @param   user  user
     */

    public void deleteUser(User user) {
        getSessionFactory().getCurrentSession().delete(user);
    }

    /**
     * Update user
     *
     * @param  user user
     */

    public void updateUser(User user) {
        getSessionFactory().getCurrentSession().update(user);
    }

    /**
     * Get user
     *
     * @param  id Integer
     * @return user
     */

    public User getUserById(Integer id) {
        List<User> list = getSessionFactory().getCurrentSession()
                                            .createQuery("from User where id=?")
                                            .setParameter(0, id).list();
        return list.get(0);
    }

    /**
     * Get user List
     *
     * @return List - user list
     */

    public List<User> getUsers() {
        List<User> list = getSessionFactory().getCurrentSession().createQuery("from User").list();
        return list;
    }

}
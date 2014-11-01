package com.komet.kometsalesmvc.controller;

import java.util.List;  
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.MediaType;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.ResponseBody; 

import com.komet.kometsalesmvc.model.User;
import com.komet.kometsalesmvc.services.DataService;
import com.komet.kometsalesmvc.model.Status;

/**
 * Sample controller for going to the home page with a message
 */
  
 
    
@Controller  
@RequestMapping("/user")
/**
 *
 * @author Gaston Trujillo
 */
public class HomeController {  
  
 @Autowired  
 DataService dataServices;  
  
 //static final Logger logger = Logger.getLogger(HomeController.class);  
  
 /* Submit form in Spring Restful Services */  
 @RequestMapping(value = "/create", method = RequestMethod.POST)  
 public @ResponseBody  
 Status addUser(@RequestBody User user) {  
  try {  
   dataServices.addUser(user);
   return new Status(1, "User added Successfully !");  
  } catch (Exception e) {  
   // e.printStackTrace();  
   return new Status(0, e.toString());  
  }  
  
 }  
  
 /* Ger a single objct in Json form in Spring Rest Services */  
 @RequestMapping(value = "/{id}", method = RequestMethod.GET)  
 public @ResponseBody  
 User getUser(@PathVariable("id") Integer id) {  
  User user = null;  
  try {  
   user = dataServices.getUserById(id);
  
  } catch (Exception e) {  
   e.printStackTrace();  
  }  
  return user;  
 }  
  
 /* Getting List of objects in Json format in Spring Restful Services */  
 @RequestMapping(value = "/list", method = RequestMethod.GET)  
 public @ResponseBody  
 List<User> getUsers() {  
  
    List<User> userList = null;  
    try {  
     userList = dataServices.getUsers();

    } catch (Exception e) {  
     e.printStackTrace();  
    }  

    return userList;  
 }  
  
 /* Delete an object from DB in Spring Restful Services */  
 @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)  
 public @ResponseBody  
 Status deleteUser(@PathVariable("user") User user) {  
  
    try {  
     dataServices.deleteUser(user);
     return new Status(1, "User deleted Successfully !");  
    } catch (Exception e) {  
     return new Status(0, e.toString());  
    }  
 }
 
}  

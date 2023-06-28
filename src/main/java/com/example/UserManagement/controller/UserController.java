package com.example.UserManagement.controller;

import com.example.UserManagement.model.User;
import com.example.UserManagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class UserController {
   @Autowired
   UserService userService;


   @GetMapping("users")
   public List<User> getAllUsers(){
      return userService.getAllUsers();
   }
   @PostMapping("users")
   String addUsers(@Valid  @RequestBody List<User>users){

      return userService.createUsers(users);
   }
   @PostMapping("user")
   String addUser(@Valid @RequestBody User user)
   {
      return userService.createUser(user);
   }
   @DeleteMapping("user")
   String removeUser(@RequestParam @Max(10000) Integer id)
   {
      return userService.removeUser(id);
   }
   @RequestMapping(value = "user/{id}/email/{emailId}",method = PUT)
   String updateEmail(@PathVariable Integer id, @PathVariable @Email String emailId)
   {
      return userService.updateEmail(id,emailId);
   }
}

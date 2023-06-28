package com.example.UserManagement.service;

import com.example.UserManagement.model.User;
import com.example.UserManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
@Autowired
UserRepo userRepo;
    public List<User> getAllUsers() {
        return userRepo.getUsers();
    }

    public String createUsers(List<User>users) {
        List<User>originalList=getAllUsers();
         originalList.addAll(users);
         return "new Users added!!";
    }


        public String createUser(User user) {
            List<User> originalList = getAllUsers();
            originalList.add(user);
            return "New user added";
        }

    public String removeUser(Integer id) {
        List<User> originalList = getAllUsers();
        for(User u : originalList)
        {
            if(id.equals(u.getUserId()))
            {
                originalList.remove(u);
                return "removed";
            }
        }
        return "Id not found";

    }

    public String updateEmail(Integer id, String emailId) {

        List<User> originalList = getAllUsers();
        for(User u : originalList)
        {
            if(id.equals(u.getUserId()))
            {
                u.setUserEmail(emailId);
                return "updated";
            }
        }
        return "Id not found";

    }
}


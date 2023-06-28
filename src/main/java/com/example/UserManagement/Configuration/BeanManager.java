package com.example.UserManagement.Configuration;

import com.example.UserManagement.model.Type;
import com.example.UserManagement.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanManager {
    @Bean
    public List<User> getInitializedList(){



        User initUser = new User(0, "Disha", "disha@gmail.com", "987654321", LocalDate.of(1998, 7, 8), "08-09-23", "12.05 pm", Type.ADMIN);
        List<User> initList = new ArrayList<>();
        initList.add(initUser);
        return initList;
    }


}

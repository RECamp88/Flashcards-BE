package com.revature.SpringBootRefresher.services;

import com.revature.SpringBootRefresher.models.User;
import com.revature.SpringBootRefresher.repos.UserRepo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User registerUser(User user){
        return userRepo.save(user);
    }

    public User loginUser(User user) throws ServiceException{
        User userLogin = userRepo.findByUsername(user.getUsername());
        if(userLogin == null || !userLogin.getPassword().equals(user.getPassword())){
            throw new ServiceException("Incorrect username or password.");
        }
        return userLogin;
    }
}

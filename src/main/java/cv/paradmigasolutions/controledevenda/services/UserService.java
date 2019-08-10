/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.services;

import cv.paradmigasolutions.controledevenda.model.Role;
import cv.paradmigasolutions.controledevenda.model.User;
import cv.paradmigasolutions.controledevenda.repository.UserRepository;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class UserService {
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public void create(User user) {
     
        String pass = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(pass));
        userRepository.save(user);
    }

//    public static void main(String[] args) {
//       
//       BCryptPasswordEncoder b = new BCryptPasswordEncoder();
//        System.out.println(b.encode("ailson"));
//    }
}

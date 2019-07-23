/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.services;

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
    private static BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public static void main(String[] args) {
       
       BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        System.out.println(b.encode("ailson"));
    }
}

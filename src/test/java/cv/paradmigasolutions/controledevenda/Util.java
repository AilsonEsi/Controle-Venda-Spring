/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author programmer
 */
public class Util {

    public static void main(String[] args) {

        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        System.out.println(b.encode("ailson"));

    }
}

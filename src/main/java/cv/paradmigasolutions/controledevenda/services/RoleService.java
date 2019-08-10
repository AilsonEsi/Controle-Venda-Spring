/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.services;

import cv.paradmigasolutions.controledevenda.model.Role;
import cv.paradmigasolutions.controledevenda.repository.RolesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class RoleService {

    @Autowired
    private RolesRepository rolesRepository;

    public List<Role> getAllRoles() {

        return rolesRepository.findAll();
    }
}

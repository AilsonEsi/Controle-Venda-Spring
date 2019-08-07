/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author programmer
 */
@Entity(name = "usr_users")
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Integer id;
    @Column(name = "usr_username", nullable=false, length = 50)
    private String username;
    @Column(name = "usr_email", nullable = false)
    private String email;
    @Column(name = "usr_password", nullable = false)
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "usr_role",
            joinColumns = {
                @JoinColumn(name = "USER_ID", referencedColumnName = "USR_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;
}

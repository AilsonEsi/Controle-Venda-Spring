/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.model;

import java.io.Serializable;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author programmer
 */
@Entity(name = "usr_users")
@Data
@ToString
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Integer id;
    @Column(name = "usr_username", nullable = false, length = 30, unique = true)
    @NotNull(message = "Obrigatório")
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max = 30, min = 20, message = "Minimo 20 e Maximo 30 caracteres")
    private String username;
    @Column(name = "usr_email", nullable = false, unique = true)
    @Email(message = "Email inválido")
    @NotNull(message = "Obrigatório")
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max = 60, min = 30, message = "Mínimo 30 e Maximo 60 caracteres")
    private String email;
    @Column(name = "usr_password", nullable = false)
    @NotNull(message = "Obrigatorio")
    @NotEmpty(message = "Preenchimento obrigatorio")
    @Length(max = 60, min = 30, message = "Mínimo 30 e Maximo 60 caracteres")
    private String password;
    @NotNull(message = "Obrigatorio")
    @NotEmpty(message = "Preenchimento obrigatório")
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "usr_role",
            joinColumns = {
                @JoinColumn(name = "USER_ID", referencedColumnName = "USR_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;
}

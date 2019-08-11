/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

/**
 *
 * @author programmer
 */
@Entity(name = "fn_fornecedor")
@Getter
@Setter
public class Fornecedor extends AudityModel<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fn_id")
    private Integer id;

    @NotNull(message = "Obrigatório")
    @Column(name = "fn_nif", nullable = false, unique = true)
    private Long nif;

    @NotNull(message = "NIB nao pode ser nulo")
    @Column(name = "fn_nib", nullable = false, unique = true)
    private Long nib;

    @NotNull(message = "Obrigatório")
    @NotBlank(message = "Preenchimento obrigatorio")
    @Column(name = "fn_name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "fn_email", nullable = false, unique = true, length = 50)
    @NotNull(message = "Obrigatório")
    @NotBlank(message = "Preenchimento obrigatorio")
    @Email(message = "Email invalido")
    private String email;

    @Column(name = "fn_description", length = 50)
    private String description;

    @NotNull(message = "Obrigatório")
    @NotBlank(message = "Preenchimento obrigatorio")
    @Column(name = "fn_phone", nullable = false, unique = true)
    private String phone;

    @NotNull(message = "Obrigatório")
    @Column(name = "fn_zipCode", nullable = false)
    private Integer zip;

    @Column(name = "fn_address", nullable = false, length = 100)
    private String address;

    @Column(name = "fn_city", nullable = true, length = 50)
    private String city;

    @Column(name = "fn_obs", nullable = true, length = 255)
    private String obs;
}

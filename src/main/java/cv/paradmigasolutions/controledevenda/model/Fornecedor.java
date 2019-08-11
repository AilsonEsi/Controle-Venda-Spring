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
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

/**
 *
 * @author programmer
 */
@Entity(name = "fn_fornecedor")
@Data
@ToString
public class Fornecedor extends AudityModel<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fn_id")
    private Integer id;

    @NotNull(message = "Obrigatório")
    @Column(name = "fn_nif", nullable = false, unique = true, length = 50)
    @Length(min = 1, max = 50, message = "Mínimo 1 e Maximo 50 dígito")
    private String nif;

    @NotNull(message = "Obrigatório")
    @Column(name = "fn_nib", nullable = false, unique = true, length = 50)
    @Length(min = 1, max = 50, message = "Mínimo 1 e Maximo 50 dígito")
    private String nib;

    @NotNull(message = "Obrigatório")
    @NotBlank(message = "Preenchimento obrigatorio")
    @Column(name = "fn_name", nullable = false, unique = true, length = 50)
    @Length(min = 6, max = 50, message = "Mínimo 6 e Maximo 50 caracteres")
    private String name;

    @Column(name = "fn_email", nullable = false, unique = true, length = 50)
    @NotNull(message = "Obrigatório")
    @NotBlank(message = "Preenchimento obrigatorio")
    @Length(min = 15, max = 60, message = "Mínimo 15 e Maximo 60 caracteres")
    @Email(message = "Email invalido")
    private String email;

    @Column(name = "fn_description", length = 40)
    @Length(max = 40, message = "Maximo 40 caracteres")
    private String description;

    @NotNull(message = "Obrigatório")
    @NotBlank(message = "Preenchimento obrigatorio")
    @Column(name = "fn_phone", nullable = false, unique = true, length = 20)
    @Length(min = 12, max = 20, message = "Mínimo 12 e Maximo 20 caracteres")
    private String phone;

    @NotNull(message = "Obrigatório")
    @Column(name = "fn_zipCode", nullable = false)
    private Integer zip;

    @Column(name = "fn_address", nullable = false, length = 60)
    @NotNull(message = "Obrigatório")
    @NotBlank(message = "Preenchimento obrigatorio")
    @Length(max = 60, message = "Maximo 60 caracteres")
    private String address;

    @Column(name = "fn_city", nullable = true, length = 50)
    @Length(max = 50, message = "Maximo 50 caracteres")
    private String city;

    @Column(name = "fn_obs", nullable = true, length = 255)
    @Length(max = 255, message = "Maximo 255 caracteres")
    private String obs;
}

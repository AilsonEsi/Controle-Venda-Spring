/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.model;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author programmer
 */
@Entity(name = "fn_fornecedor")
@Getter
@Setter
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fn_id")
    private Integer id;
    @Column(name = "fn_nib", nullable = false)
    private Integer nib;
    @Column(name = "fn_name", nullable = false)
    private String name;
    @Column(name = "fn_email", nullable = false)
    private String email;
    @Column(name = "fn_description", nullable = false)
    private String description;
    @Column(name = "fn_phone", nullable = false)
    private String phone;
    @Column(name = "fn_zipCode", nullable = false)
    private Integer zip;
    @Column(name = "fn_address", nullable = false)
    private String address;
    @ElementCollection
    @CollectionTable(name = "fn_city")
    private List<String> city;
    @Column(name = "fn_obs", nullable = true)
    private String obs;
}

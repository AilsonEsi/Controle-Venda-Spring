/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.paradmigasolutions.controledevenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author programmer
 */
@Entity(name = "pdt_produto")
@Data
@ToString
public class Produto extends AudityModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pdt_id")
    private Integer id;

    @Column(name = "pdt_cod", nullable = true, unique = true)
    @Length(max = 50, message = "Maximo 50 caracteres")
    private String cod;
    
    @Column(name = "pdt_name", nullable = false, unique = true)
    @NotNull(message = "{not.null}")
    @NotBlank(message = "{not.blank}")
    @Length(min = 1, max = 100, message = "Minimo 1 e Maximo 100 caracteres")
    private String name;

    @Column(name = "pdt_description", nullable = true)
    @Length(message = "Maximo 40 caracteres", max = 40)
    private String desc;

    @Column(name = "pdt_buy_price", nullable = false)
    @NotNull(message = "{not.null}")
    private Float buyPrice;

    @Column(name = "pdt_sell_price", nullable = false)
    @NotNull(message = "{not.null}")
    private Float sellPrice;

    @Column(name = "pdt_group", nullable = false)
    @NotNull(message = "{not.null}")
    @NotBlank(message = "{not.blank}")
    @Length(min = 1, max = 50, message = "Minimo 1 e Maximo 50 caracteres")
    private String group;

    @Column(name = "pdt_sub_group", nullable = true)
    @Length(max = 50, message = "Maximo 50 caracteres")
    private String subGroup;

    @Column(name = "pdt_img_url", nullable = false)
    @NotNull(message = "{not.null}")
    @NotBlank(message = "{not.blank}")
    private String imgURL;

    @Column(name = "pdt_obs", nullable = true)
    @Length(max = 255, message = "Maximo 255 caracteres")
    private String obs;

    @Column(name = "pdt_quantity", nullable = false)
    @NotNull(message = "{not.null}")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor")
    private Fornecedor fornecedor;
    
    @Column(name = "pdt_fabricator", nullable = true)
    @Length(max = 100, message = "Maximo 100 caracteres")
    private String fabricator;
}

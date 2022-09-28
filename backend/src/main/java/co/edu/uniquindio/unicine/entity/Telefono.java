package co.edu.uniquindio.unicine.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Telefono implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String numero;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Teatro teatro;

}

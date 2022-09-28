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
public class CompraConfiteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 11, unique = true)
    private int codigo;

    private Double precio;

    private int unidades;

    @ManyToOne
    private Compra compra;

    @ManyToOne
    private Confiteria confiteria;
}

package co.edu.uniquindio.unicine.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Funcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 11, unique = true)
    private int codigo;

    private Double precio;

    @ManyToOne
    private Pelicula pelicula;

    @ManyToOne
    private Horario horario;

    @OneToMany(mappedBy = "funcion")
    private List<Compra> compras;

    @ManyToOne
    private Sala sala;

}

package co.edu.uniquindio.unicine.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class DistribucionSillas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 11, unique = true)
    private int codigo;

    private String esquema;

    private int totalSillas;

    private int filas;

    private int columnas;

    @OneToMany(mappedBy = "distribucion")
    @ToString.Exclude
    private List<Sala> salas = new ArrayList<>();
}

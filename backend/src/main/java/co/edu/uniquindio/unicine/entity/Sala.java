package co.edu.uniquindio.unicine.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 11, unique = true)
    private int codigo;

    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    @Size(max = 50, message = "El nombre de la sala no puede tener mas de 50 caracteres")
    @NotBlank(message = "El nombre de la sala no puede estar vacío")
    private String nombre;

    @ManyToOne
    private Teatro teatro;

    @ManyToOne
    private DistribucionSillas distribucion;

    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;

}

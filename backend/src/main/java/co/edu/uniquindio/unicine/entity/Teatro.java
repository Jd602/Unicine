package co.edu.uniquindio.unicine.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Teatro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @ToString.Include
    @Column(nullable = false)
    private String direccion;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "teatro")
    private List<Sala> salas = new ArrayList<>();

    @OneToMany(mappedBy = "teatro")
    private List<Telefono> telefonos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teatro teatro = (Teatro) o;

        return codigo == teatro.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }


}

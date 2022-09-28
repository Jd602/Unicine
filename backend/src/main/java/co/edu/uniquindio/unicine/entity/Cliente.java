package co.edu.uniquindio.unicine.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 11, unique = true)
    private int codigo;

    @Column(nullable = false, length = 50)
    @EqualsAndHashCode.Include
    @Size(max = 50, message = "El nombre del cliente no puede tener mas de 50 caracteres")
    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    private String nombre;

    private LocalDate fechaNacimiento;

    @Email(message = "El correo electrónico no es válido")
    @Column(length = 150, nullable = false, unique = true)
    @Size(max = 150, message = "El correo electrónico debe tener máximo 150 caracteres")
    @NotBlank(message = "Debe de escribir su correo electrónico")
    private String email;

    private String fotoUrl;

    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "El password debe tener máximo 50 caracteres")
    @NotBlank(message = "Debe de escribir su password")
    private String password;

    private EstadoCliente estado;

    @OneToMany(mappedBy = "cliente")
    private List<Telefono> telefonos;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    @OneToMany(mappedBy = "cliente")
    private List<CuponCliente> cuponesCliente;
}

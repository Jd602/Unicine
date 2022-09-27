package co.edu.uniquindio.unicine.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Admin_Teatro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private int codigo;

    @Email(message = "El correo electrónico no es válido")
    @Column(length = 150, nullable = false, unique = true)
    @Size(max = 150, message = "El correo electrónico debe tener máximo 150 caracteres")
    @NotBlank(message = "Debe de escribir su correo electrónico")
    @ToString.Include
    private String email;

    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "El password debe tener máximo 50 caracteres")
    @NotBlank(message = "Debe de escribir su password")
    @ToString.Include
    private String password;
}

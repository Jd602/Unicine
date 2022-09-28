package co.edu.uniquindio.unicine.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 11, unique = true)
    private int codigo;

    private String medioPago;

    private LocalDateTime fechaCompra;

    private Double valorTotal;

    @OneToMany(mappedBy = "compra")
    private List<Entrada> entradas;

    @ManyToOne
    private Funcion funcion;

    @OneToMany(mappedBy = "compra")
    private List<CompraConfiteria> comprasConfiteria;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private CuponCliente cuponCliente;
}

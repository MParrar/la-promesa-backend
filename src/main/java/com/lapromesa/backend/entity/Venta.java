package com.lapromesa.backend.entity;

import lombok.*;


import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name="nombre_cliente")
    private String nombreCliente;

    private String lugar;

    private Long monto;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "tipo_de_venta")
    private String tipoDeVenta;

    private String observacion;

}

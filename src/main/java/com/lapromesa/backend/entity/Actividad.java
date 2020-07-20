package com.lapromesa.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDeActividad;

    private String lugar;

    private Date fecha;

    private Long total;

    private boolean estado;

    @JsonIgnoreProperties(value = { "actividad", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Trabajador trabajador;




}

package com.lapromesa.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(name = "fecha_de_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    private Long sueldo;

    private Long abono;

    @JsonIgnoreProperties(value = { "trabajador", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trabajador", cascade = CascadeType.ALL)
    private List<Actividad> actividad;
}

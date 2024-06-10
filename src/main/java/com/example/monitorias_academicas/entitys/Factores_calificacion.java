package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@NonNull
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "factores_calificacion")
@Builder
public class Factores_calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID factores_calificacion_id;

    @Column(nullable = false)
    private String calificacion;

    @Column(nullable = false)
    private String observaciones;

    @Column(nullable = false)
    private String tipo;

    @OneToMany(mappedBy = "factores_calificacion")
    private List<Prueba> prueba;
}

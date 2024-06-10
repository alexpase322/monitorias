package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "monitoria_prueba")
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Data
@Builder
public class Monitoria_prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID monitoria_prueba_id;

    private String calificacion;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "oferta_monitoria")
    private Oferta_monitoria oferta_monitoria;

    @ManyToOne
    @JoinColumn(name = "prueba")
    private Prueba prueba;
}

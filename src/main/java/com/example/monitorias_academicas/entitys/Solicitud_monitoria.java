package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "solicitud_monitoria")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class Solicitud_monitoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID solicitud_monitoria_id;

    private String observacion;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "oferta_monitoria")
    private Oferta_monitoria oferta_monitoria;

    @ManyToOne
    @JoinColumn(name = "solicitud")
    private Solicitud solicitud;
}

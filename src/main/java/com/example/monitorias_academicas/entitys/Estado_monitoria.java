package com.example.monitorias_academicas.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NonNull
@Table(name = "estado_monitoria")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estado_monitoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "estado_monitoria_id")
    private UUID estadoMonitoriaId;

    private String observaciones;

    private LocalDateTime update_at;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "oferta_monitoria")
    private Oferta_monitoria oferta_monitoria;

}

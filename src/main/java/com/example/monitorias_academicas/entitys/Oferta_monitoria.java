package com.example.monitorias_academicas.entitys;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NonNull
@Table(name = "oferta_monitoria")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Oferta_monitoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID oferta_monitoria_id;

    private int numero_vacantes;

    private LocalDateTime fecha_inicio_inscripcion;

    private LocalDateTime fecha_fin_inscripcion;

    private LocalDateTime fecha_inicio_monitoria;

    private LocalDateTime fecha_fin_monitoria;

    private double intensidad_horaria;

    @OneToOne
    @JoinColumn(name = "monitoria")
    private Monitoria monitoria;

    @OneToMany(mappedBy = "oferta_monitoria")
    private List<Estado_monitoria> estado_monitoria;

    @OneToMany(mappedBy = "oferta_monitoria")
    private List<Requisito_Monitoria> requisito_monitoria;

    @OneToMany(mappedBy = "oferta_monitoria")
    private List<Monitoria_prueba> monitoria_prueba;

    @OneToMany(mappedBy = "oferta_monitoria")
    private List<Solicitud_monitoria> solicitud_monitoria;
}

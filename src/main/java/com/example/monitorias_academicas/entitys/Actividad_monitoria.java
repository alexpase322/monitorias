package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NonNull
@Table(name = "actividad_monitoria")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actividad_monitoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID actividad_monitoria_id;

    @ManyToOne
    @JoinColumn(name = "monitoria")
    private Monitoria monitoria;

    @ManyToOne
    @JoinColumn(name = "actividad")
    private Actividad actividad;


}

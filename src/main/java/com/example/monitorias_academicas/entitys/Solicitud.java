package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Table(name = "solicitud")
@Data
@Builder
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID solicitud_id;

    private UUID es_codigo;

    private LocalDateTime solicitud_fecha;

    private String estado;

    @OneToMany(mappedBy = "solicitud")
    private List<Solicitud_monitoria> Solicitud_monitoria;
}

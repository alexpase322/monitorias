package com.example.monitorias_academicas.entitys;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NonNull
@Table(name = "actividad_estado")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActividadEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID actividad_estado_id;

    private String estado;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "actividadEstado", fetch = FetchType.LAZY)
    private List<Actividad> actividad;
}

package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prueba")
@NonNull
@Builder
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID prueba_id;

    private String nombre;

    private LocalDateTime fecha;

    private String observaciones;

    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "factores_calificacion")
    private Factores_calificacion factores_calificacion;

    @OneToMany(mappedBy = "prueba")
    private List<Monitoria_prueba> monitoria_prueba;

    @PrePersist
    public void prePersist() {
        this.fecha = LocalDateTime.now();
    }
}

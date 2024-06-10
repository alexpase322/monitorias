package com.example.monitorias_academicas.entitys;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NonNull
@Table(name = "actividad")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, name = "actividad")
    private UUID actividad_id;

    @Column(nullable = false, updatable = true)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private String lugar;

    @PrePersist
    public void prePersist(){this.fecha = LocalDateTime.now();}

    @ManyToOne
    @JoinColumn(name = "actividad_estado")
    private ActividadEstado actividadEstado;

    @OneToOne
    @JoinColumn(name = "tipo_actividad")
    private type_actividad tipo_actividad;

    @OneToMany(mappedBy = "actividad")
    private List<Actividad_monitoria> actividad_monitoria;


}

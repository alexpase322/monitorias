package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NonNull
@Table(name = "monitoria")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monitoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "monitoria")
    private UUID monitoria_id;

    private String nombre;

    @Column(length = 255)
    private String descripcion;

    private int numeroVacantes;
    private UUID es_codigo;
    private UUID per_codigo;

    private String obs_supervisor;
    private String obs_monitoria;

    @OneToMany(mappedBy = "monitoria")
    private List<Actividad_monitoria> actividad_monitorias;

    @ManyToOne
    private Tipo_monitoria tipo_monitoria;

    private String estado;
}

package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Table(name = "tipo_monitoria")
@Builder
public class Tipo_monitoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID tipo_monitoria_id;

    private int tipo;

    private String descripcion;

    @OneToMany(mappedBy = "tipo_monitoria")
    private List<Monitoria> monitoria;
}

package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NonNull
@Table(name = "type_actividad")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class type_actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID type_actividad_id;

    private String tipo_actividad;

}

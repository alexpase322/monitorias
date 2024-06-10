package com.example.monitorias_academicas.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NonNull
@Table(name = "requisitos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Requisito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID requisito_id;

    private String descripcion;

    private String estado;

    @OneToMany(mappedBy = "requisito")
    private List<Requisito_Monitoria> requisito_monitorias;


}

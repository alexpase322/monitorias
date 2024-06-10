package com.example.monitorias_academicas.entitys;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Table(name = "requisito_monitoria")
@Builder
public class Requisito_Monitoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID requisito_monitoria_id;

    @ManyToOne
    @JoinColumn(name = "requisito")
    private Requisito requisito;

    @ManyToOne
    @JoinColumn(name = "oferta_monitoria")
    private Oferta_monitoria oferta_monitoria;
}

package com.example.monitorias_academicas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactoresCalificacionDTO {
    String calificacion;
    String observaciones;
    String tipo;
}

package com.example.monitorias_academicas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PruebaDTO {
    String nombrePruebaDto;

    LocalDateTime fechaPruebaDTO;

    String observacionesPruebaDTO;
}

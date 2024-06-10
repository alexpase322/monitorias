package com.example.monitorias_academicas.dao.Prueba;

import com.example.monitorias_academicas.dto.PruebaDTO;
import com.example.monitorias_academicas.entitys.Prueba;

import java.util.List;
import java.util.UUID;

public interface PruebaDao {
    Prueba createPrueba(PruebaDTO pruebaDTO);

    Prueba getPruebaByName(String nombre);

    List<Prueba> getAllPrueba();

    Prueba updatePrueba(Prueba prueba);

    void deletePruebaById(UUID id);
}

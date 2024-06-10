package com.example.monitorias_academicas.dao.FactoresCalificacion;

import com.example.monitorias_academicas.dto.FactoresCalificacionDTO;
import com.example.monitorias_academicas.entitys.Factores_calificacion;

import java.util.List;

public interface FactoresCalificacionDao {
    Factores_calificacion createFactores(Factores_calificacion factores);

    List<Factores_calificacion> getAllFactores();

    Factores_calificacion getByTipo(String tipo);

    Factores_calificacion updateFactores(String tipo, FactoresCalificacionDTO factores);
}

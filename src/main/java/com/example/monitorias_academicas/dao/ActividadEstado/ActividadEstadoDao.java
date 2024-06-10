package com.example.monitorias_academicas.dao.ActividadEstado;

import com.example.monitorias_academicas.entitys.ActividadEstado;

import java.util.List;
import java.util.UUID;

public interface ActividadEstadoDao {
    ActividadEstado createActivadEstado(ActividadEstado actividadEstado);

    ActividadEstado getByUUID(UUID id);

    List<ActividadEstado> getAll();

    void deleteActividadEstadoById(UUID id);

    ActividadEstado updateByEstado(String estado);
}

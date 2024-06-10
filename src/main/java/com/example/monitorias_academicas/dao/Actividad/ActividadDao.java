package com.example.monitorias_academicas.dao.Actividad;

import com.example.monitorias_academicas.entitys.Actividad;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ActividadDao {
    Actividad createActividad(Actividad actividad);

    Actividad getActividadByUUID(UUID id);

    List<Actividad> getAll();

    void deleteActividadbyUUID(UUID id, UUID idActividadEstado);
}

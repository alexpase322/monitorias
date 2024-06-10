package com.example.monitorias_academicas.dao.Solicitud;

import com.example.monitorias_academicas.entitys.Solicitud;

import java.util.List;
import java.util.UUID;

public interface SolicitudDao {
    Solicitud createSolicitud(Solicitud solicitud);

    List<Solicitud> getAllSolicitud();

    Solicitud getByEsCodigo(UUID esCodigo);

    Solicitud deleteByEsCodigo(UUID esCodigo);
}

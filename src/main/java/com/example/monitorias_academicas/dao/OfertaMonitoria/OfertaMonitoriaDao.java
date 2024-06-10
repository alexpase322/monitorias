package com.example.monitorias_academicas.dao.OfertaMonitoria;

import com.example.monitorias_academicas.entitys.Oferta_monitoria;

import java.util.List;
import java.util.UUID;

public interface OfertaMonitoriaDao {

    Oferta_monitoria createOferta(Oferta_monitoria oferta_monitoria);

    void deleteOfertaMonitoria(String id);

    List<Oferta_monitoria> getAll(String estado);

    Oferta_monitoria getByUUID(UUID id);

    Oferta_monitoria editOfertaMonitoria(Oferta_monitoria oferta_monitoria);
}

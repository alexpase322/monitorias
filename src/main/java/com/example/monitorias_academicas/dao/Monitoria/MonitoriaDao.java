package com.example.monitorias_academicas.dao.Monitoria;


import com.example.monitorias_academicas.entitys.Monitoria;

import java.util.List;
import java.util.UUID;

public interface MonitoriaDao {
    List<Monitoria> getAllMonitoria();

    Monitoria getMonitoriaByUUID(UUID id);

    Monitoria editMonitoria(Monitoria monitoria);

    Monitoria deleteMonitoria(UUID id);

    Monitoria createMonitoria(Monitoria monitoria);

    List<Monitoria> getMonitoriaByName(String nombre);
}

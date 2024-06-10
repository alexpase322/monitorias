package com.example.monitorias_academicas.dao.EstadoMonitoria;

import com.example.monitorias_academicas.entitys.Estado_monitoria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EstadoMonitoriaDao {

    Estado_monitoria createEstado(Estado_monitoria estadoMonitoria);

    ResponseEntity<List<Estado_monitoria>> getAllEstadoMonitoria();

    ResponseEntity<List<Estado_monitoria>> getByEstado(String estado);

    //ResponseEntity<Estado_monitoria> updateEstado(Estado_monitoria estadoMonitoria);
}

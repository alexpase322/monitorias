package com.example.monitorias_academicas.dao.Actividad_Monitoria;

import com.example.monitorias_academicas.entitys.Actividad;
import com.example.monitorias_academicas.entitys.Actividad_monitoria;
import com.example.monitorias_academicas.entitys.Monitoria;

public interface ActividadMonitoriaDao {
    void setMonitoriaYActividad(String monitoriaId, String actividadId);

    Actividad_monitoria getActividadMonitoriaByIdActividad(String actividadId);

    Actividad_monitoria getActividadMonitoriaByIdMonitoria(String monitoriaId);
}

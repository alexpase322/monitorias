package com.example.monitorias_academicas.dao.Actividad_Monitoria;


import com.example.monitorias_academicas.dao.Actividad.ActividadDao;
import com.example.monitorias_academicas.dao.Monitoria.MonitoriaDao;
import com.example.monitorias_academicas.entitys.Actividad;
import com.example.monitorias_academicas.entitys.Actividad_monitoria;
import com.example.monitorias_academicas.entitys.Monitoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public class ActividadMonitoriaDaoImplement implements ActividadMonitoriaDao {
    @PersistenceContext
    EntityManager em;

    @Autowired
    MonitoriaDao monitoriaDao;

    @Autowired
    ActividadDao actividadDao;

    @Override
    public void setMonitoriaYActividad(String monitoriaId, String actividadId) {
        try {
            Monitoria monitoria = monitoriaDao.getMonitoriaByUUID(UUID.fromString(monitoriaId));
            Actividad actividad = actividadDao.getActividadByUUID(UUID.fromString(actividadId));
            Actividad_monitoria actividadMonitoria = Actividad_monitoria.builder()
                    .monitoria(monitoria)
                    .actividad(actividad)
                    .build();
            em.merge(actividadMonitoria);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Actividad_monitoria getActividadMonitoriaByIdActividad(String actividadId){
        try {
            String query = "SElECT m FROM Actividad_monitoria m WHERE m.actividad.actividad_id = :actividadId";
            return em.createQuery(query, Actividad_monitoria.class).setParameter("actividadId", actividadId).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Actividad_monitoria getActividadMonitoriaByIdMonitoria(String monitoriaId){
        try {
            String query = "SELECT m FROM Actividad_monitoria m WHERE m.monitoria.monitoria_id = :monitoriaId";
            return em.createQuery(query, Actividad_monitoria.class).setParameter("monitoriaId", monitoriaId).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}

package com.example.monitorias_academicas.dao.Monitoria;
import com.example.monitorias_academicas.dao.Actividad.ActividadDao;
import com.example.monitorias_academicas.dao.Actividad_Monitoria.ActividadMonitoriaDao;
import com.example.monitorias_academicas.entitys.Actividad;
import com.example.monitorias_academicas.entitys.Actividad_monitoria;
import com.example.monitorias_academicas.entitys.Monitoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class MonitoriaDaoImplement implements MonitoriaDao {
    @PersistenceContext
    EntityManager em;

    @Autowired
    ActividadDao actividadDao;

    @Override
    public List<Monitoria> getAllMonitoria(){
        try {
            String query = "SELECT m FROM Monitoria m WHERE m.estado = 'Activa'";
            List<Monitoria> monitorias = em.createQuery(query).getResultList();
            return monitorias;
        }catch (Exception e){
            System.out.print(e.getMessage());
            return null;
        }
    }

    @Override
    public Monitoria getMonitoriaByUUID(UUID id){
        try {
            String query = "SELECT m FROM Monitoria m WHERE m.monitoria_id = :id";
            return (Monitoria) em.createQuery(query).setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.print(e.getMessage());
            return null;
        }
    }

    @Override
    public Monitoria editMonitoria(Monitoria monitoria){
        try {
            String query = "SELECT m FROM Monitoria m WHERE m.monitoria_id = :id";
            Monitoria monitoriaFound = (Monitoria) em.createQuery(query).setParameter("id", monitoria.getMonitoria_id()).getSingleResult();
            monitoriaFound.builder()
                    .actividad_monitorias(monitoria.getActividad_monitorias())
                    .nombre(monitoria.getNombre())
                    .descripcion(monitoria.getDescripcion())
                    .numeroVacantes(monitoria.getNumeroVacantes())
                    .obs_monitoria(monitoria.getObs_monitoria())
                    .obs_supervisor(monitoria.getObs_supervisor())
                    .tipo_monitoria(monitoria.getTipo_monitoria())
                    .actividad_monitorias(monitoria.getActividad_monitorias())
                    .per_codigo(monitoria.getPer_codigo())
                    .build();
            return em.merge(monitoriaFound);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Monitoria deleteMonitoria(UUID id){
        try {
            String query = "SELECT m FROM Monitoria m WHERE m.monitoria_id = :id";
            Monitoria monitoria = (Monitoria) em.createQuery(query).setParameter("id", id).getSingleResult();
            monitoria.setEstado("Inactiva");
            return em.merge(monitoria);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Monitoria createMonitoria(Monitoria monitoria){
        try{
            return em.merge(monitoria);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Monitoria> getMonitoriaByName(String nombre){
        try {
            String query = "SELECT m FROM Monitoria m WHERE m.nombre = :nombre";
            List<Monitoria> monitorias = em.createQuery(query).setParameter("nombre", nombre).getResultList();
            return monitorias;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}

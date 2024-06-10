package com.example.monitorias_academicas.dao.Actividad;

import com.example.monitorias_academicas.dao.ActividadEstado.ActividadEstadoDao;
import com.example.monitorias_academicas.dao.Actividad_Monitoria.ActividadMonitoriaDao;
import com.example.monitorias_academicas.entitys.Actividad;
import com.example.monitorias_academicas.entitys.ActividadEstado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class ActividadDaoImplement implements ActividadDao{
    @PersistenceContext
    EntityManager em;


    @Autowired
    ActividadEstadoDao actividadEstadoDao;

    @Override
    public Actividad createActividad(Actividad actividad) {
        try {
            return em.merge(actividad);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Actividad getActividadByUUID(UUID id){
        try{
            String query = "SELECT a FROM Actividad a WHERE a.actividad_id = :id AND a.actividadEstado.estado = 'activo'";
            return em.createQuery(query, Actividad.class).setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Actividad> getAll(){
        try {
            String query = "SELECT a FROM Actividad a WHERE a.actividadEstado.estado = 'activo'";
            List<Actividad> Actividades = em.createQuery(query, Actividad.class).getResultList();
            if(Actividades.isEmpty()){
                return null;
            }
            return Actividades;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteActividadbyUUID(UUID id, UUID idActividadEstado){
        try {
            String query = "SELECT a FROM Actividad a WHERE a.actividad_id = :id AND a.actividadEstado.estado = 'activo'";
            Actividad actividad = em.createQuery(query, Actividad.class).setParameter("id", id).getSingleResult();
            ActividadEstado actividadEstado = actividadEstadoDao.getByUUID(idActividadEstado);
            actividad.setActividadEstado(actividadEstado);
            em.merge(actividad);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

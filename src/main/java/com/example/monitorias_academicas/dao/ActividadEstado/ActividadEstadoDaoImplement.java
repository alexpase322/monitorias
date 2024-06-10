package com.example.monitorias_academicas.dao.ActividadEstado;


import com.example.monitorias_academicas.entitys.ActividadEstado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class ActividadEstadoDaoImplement implements ActividadEstadoDao{

    @PersistenceContext
    EntityManager em;

    @Override
    public ActividadEstado createActivadEstado(ActividadEstado actividadEstado){
        try{
            String query = "SELECT ac FROM ActividadEstado ac WHERE ac.estado = LOWER(:estado)";
            List<ActividadEstado> actividadEstados = em.createQuery(query).setParameter("estado", actividadEstado.getEstado().toLowerCase()).getResultList();
            if(actividadEstados.isEmpty()){
               return em.merge(actividadEstado);
            }
            return null;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ActividadEstado getByUUID(UUID id){
        try {
            String query = "SELECT ac FROM ActividadEstado ac WHERE ac.actividad_estado_id = :id";
            return em.createQuery(query, ActividadEstado.class).setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<ActividadEstado> getAll(){
        try {
            String query = "SELECT ac FROM ActividadEstado ac";
            return em.createQuery(query, ActividadEstado.class).getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteActividadEstadoById(UUID id){
        try {
            String query = "SELECT ae FROM ActividadEstado ae WHERE ae.actividad_estado_id = :id";
            ActividadEstado actividad = em.createQuery(query, ActividadEstado.class).setParameter("id", id).getSingleResult();
            em.remove(actividad);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ActividadEstado updateByEstado(String estado){
        try {
            String query = "SELECT ae FROM ActividadEstado ae WHERE ae.estado = LOWER(:estado)";
            ActividadEstado actividadEstado = em.createQuery(query, ActividadEstado.class).setParameter("estado", estado).getSingleResult();
            actividadEstado.setEstado(estado);
            em.merge(actividadEstado);
            return actividadEstado;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}

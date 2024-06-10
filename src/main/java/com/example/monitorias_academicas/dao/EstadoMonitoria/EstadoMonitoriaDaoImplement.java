package com.example.monitorias_academicas.dao.EstadoMonitoria;


import com.example.monitorias_academicas.entitys.Estado_monitoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EstadoMonitoriaDaoImplement implements EstadoMonitoriaDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public Estado_monitoria createEstado(Estado_monitoria estadoMonitoria){
        try {
            String query = "SELECT e FROM Estado_monitoria e WHERE e.estado = :estado";
            Estado_monitoria estado = em.createQuery(query, Estado_monitoria.class).setParameter("estado", estadoMonitoria.getEstado()).getSingleResult();
            if(estado!=null){
                em.merge(estadoMonitoria);
                return estadoMonitoria;
            }
            return null;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /*@Override
    public ResponseEntity<Estado_monitoria> updateEstado(String estadoMonitoria){
        try {
            String query = "SELECT e FROM Estado_monitoria e WHERE e.estado = :estado";
            Estado_monitoria estado = em.createQuery(query, Estado_monitoria.class).setParameter("estado", estadoMonitoria).getSingleResult();
            if(estado.getEstado().equals(estadoMonitoria.getEstado())){
                return ResponseEntity.badRequest().build();
            }

            return null;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }*/

    @Override
    public ResponseEntity<List<Estado_monitoria>> getAllEstadoMonitoria(){
        try {
            String query = "SELECT e FROM Estado_monitoria e";
            return ResponseEntity.ok(em.createQuery(query, Estado_monitoria.class).getResultList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResponseEntity<List<Estado_monitoria>> getByEstado(String estado){
        try {
            String query = "SELECT e FROM Estado_monitoria e WHERE e.estado = :estado";
            List<Estado_monitoria> estadosMonitoria = em.createQuery(query).setParameter("estado", estado).getResultList();
            return ResponseEntity.ok(estadosMonitoria);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}

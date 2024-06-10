package com.example.monitorias_academicas.dao.FactoresCalificacion;


import com.example.monitorias_academicas.dto.FactoresCalificacionDTO;
import com.example.monitorias_academicas.entitys.Factores_calificacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class FactoresCalificacionDaoImplement implements FactoresCalificacionDao{
    @PersistenceContext
    EntityManager em;

    @Override
    public Factores_calificacion createFactores(Factores_calificacion factores){
        try {
            String query = "SELECT fc FROM Factores_calificacion fc WHERE fc.tipo = :tipo";
            Factores_calificacion factoresFound = em.createQuery(query, Factores_calificacion.class).setParameter("tipo", factores.getTipo()).getSingleResult();
            if(factoresFound != null){
                return factoresFound;
            }
            em.merge(factores);
            return factores;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Factores_calificacion> getAllFactores(){
        try {
            String query = "SELECT fc FROM Factores_calificacion fc";
            return em.createQuery(query, Factores_calificacion.class).getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Factores_calificacion getByTipo(String tipo){
        try {
            String query = "SELECT tp FROM Factores_calificacion tp WHERE tp.tipo = :tipo";
            Factores_calificacion factores = em.createQuery(query, Factores_calificacion.class).setParameter("tipo", tipo).getSingleResult();
            if(factores != null){
                return factores;
            }
            return null;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Factores_calificacion updateFactores(String tipo, FactoresCalificacionDTO factores){
        try {
            String query = "SELECT fc FROM Factores_calificacion fc WHERE fc.tipo = :tipo";
            Factores_calificacion factoresFound = em.createQuery(query, Factores_calificacion.class).setParameter("tipo", tipo).getSingleResult();
            if(factoresFound==null){
                return null;
            }
            factoresFound.setCalificacion(factores.getCalificacion());
            factoresFound.setObservaciones(factores.getObservaciones());
            factoresFound.setTipo(factores.getTipo());
            em.merge(factoresFound);
            return factoresFound;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}

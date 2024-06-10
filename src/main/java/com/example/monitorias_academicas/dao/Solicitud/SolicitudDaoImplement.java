package com.example.monitorias_academicas.dao.Solicitud;


import com.example.monitorias_academicas.entitys.Solicitud;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class SolicitudDaoImplement implements SolicitudDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public Solicitud createSolicitud(Solicitud solicitud){
        try {
            String query = "SELECT s FROM Solicitud s WHERE s.es_codigo = :esCodigo";
            Solicitud solicitudFound = em.createQuery(query, Solicitud.class).setParameter("esCodigo", solicitud.getEs_codigo()).getSingleResult();
            if(solicitudFound==null){
                em.merge(solicitud);
                return solicitud;
            }
            return null;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Solicitud> getAllSolicitud(){
        try {
            String query = "SELECT s FROM Solicitud s WHERE s.estado = LOWER('activa')";
            List<Solicitud> solicitudes = em.createQuery(query).getResultList();
            if(solicitudes.isEmpty()){
                return null;
            }
            return solicitudes;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Solicitud getByEsCodigo(UUID esCodigo){
        try {
            String query = "SELECT s FROM Solicitud s WHERE s.es_codigo = :esCodigo";
            Solicitud solicitud = em.createQuery(query, Solicitud.class).setParameter("esCodigo", esCodigo).getSingleResult();
            if(solicitud==null){
                return null;
            }
            return solicitud;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Solicitud deleteByEsCodigo(UUID esCodigo){
        try {
            String query = "SELECT s FROM Solicitud s WHERE s.es_codigo = :esCodigo";
            Solicitud solicitud = em.createQuery(query, Solicitud.class).setParameter("esCodigo", esCodigo).getSingleResult();
            if(solicitud==null){
                return null;
            }
            solicitud.setEstado("inactivo");
            em.merge(solicitud);
            return solicitud;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

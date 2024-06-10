package com.example.monitorias_academicas.dao.OfertaMonitoria;

import com.example.monitorias_academicas.dao.EstadoMonitoria.EstadoMonitoriaDao;
import com.example.monitorias_academicas.entitys.Estado_monitoria;
import com.example.monitorias_academicas.entitys.Oferta_monitoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class OfertaMonitoriaImplement implements OfertaMonitoriaDao{
    @PersistenceContext
    EntityManager em;

    @Autowired
    EstadoMonitoriaDao estadoMonitoriaDao;

    @Override
    public Oferta_monitoria createOferta(Oferta_monitoria oferta_monitoria){
        try{
            return em.merge(oferta_monitoria);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteOfertaMonitoria(String id){
        try {
            String query = "SELECT m FROM Oferta_monitoria m WHERE m.oferta_monitoria_id = :id";
            Oferta_monitoria oferta = em.createQuery(query, Oferta_monitoria.class).setParameter("id", id).getSingleResult();
            oferta.setEstado_monitoria((List<Estado_monitoria>) Estado_monitoria.builder().estado("inactivo").build());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Oferta_monitoria> getAll(String estado){
        try {
            List<Estado_monitoria> estados = estadoMonitoriaDao.getByEstado(estado).getBody();

            String query = "SELECT m FROM Oferta_monitoria m WHERE m.estado_monitoria = :estado_monitoria";
            return em.createQuery(query, Oferta_monitoria.class).getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Oferta_monitoria getByUUID(UUID id){
        try {
            String query = "SELECT m FROM Oferta_monitoria m WHERE m.oferta_monitoria_id = :id";
            return em.createQuery(query, Oferta_monitoria.class).setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Oferta_monitoria editOfertaMonitoria(Oferta_monitoria oferta_monitoria){
        try {
            String query = "SELECT m FROM Oferta_monitoria m WHERE m.oferta_monitoria_id = :id";
            Oferta_monitoria oferta = em.createQuery(query, Oferta_monitoria.class).getSingleResult();
            oferta.setEstado_monitoria(oferta_monitoria.getEstado_monitoria());
            oferta.setMonitoria_prueba(oferta_monitoria.getMonitoria_prueba());
            oferta.setEstado_monitoria(oferta_monitoria.getEstado_monitoria());
            oferta.setRequisito_monitoria(oferta_monitoria.getRequisito_monitoria());
            oferta.setFecha_inicio_inscripcion(oferta_monitoria.getFecha_inicio_inscripcion());
            oferta.setFecha_inicio_monitoria(oferta_monitoria.getFecha_inicio_monitoria());
            oferta.setFecha_fin_monitoria(oferta_monitoria.getFecha_fin_monitoria());
            oferta.setFecha_fin_inscripcion(oferta_monitoria.getFecha_fin_inscripcion());
            return em.merge(oferta);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /*@Override
    public Oferta_monitoria editEstadoMonitoria(UUID idOferta, Estado_monitoria){
        try {

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }*/

}

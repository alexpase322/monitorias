package com.example.monitorias_academicas.dao.Prueba;

import com.example.monitorias_academicas.dto.PruebaDTO;
import com.example.monitorias_academicas.entitys.Prueba;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class PruebaDaoImplement implements PruebaDao{
    @PersistenceContext
    EntityManager em;

    @Override
    public Prueba createPrueba(PruebaDTO pruebaDTO){
        try {
            String query = "SELECT p FROM Prueba p WHERE p.nombre = :nombre";
            Prueba pruebaFind = em.createQuery(query, Prueba.class).setParameter("nombre", pruebaDTO.getNombrePruebaDto()).getSingleResult();
            if(pruebaFind != null){
                return pruebaFind;
            }
            Prueba prueba = new Prueba();
            prueba.setActive(true);
            prueba.setNombre(pruebaDTO.getNombrePruebaDto());
            prueba.setFecha(pruebaDTO.getFechaPruebaDTO());
            prueba.setObservaciones(pruebaDTO.getObservacionesPruebaDTO());
            em.merge(prueba);
            return prueba;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Prueba getPruebaByName(String nombre){
        try {
            String query = "SELECT p FROM Prueba p WHERE p.nombre = :nombre AND p.isActive = true";
            Prueba prueba = em.createQuery(query, Prueba.class).setParameter("nombre", nombre).getSingleResult();
            if(prueba!=null){
                return prueba;
            }
            return null;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Prueba> getAllPrueba(){
        try {
            String query = "SELECT p FROM Prueba p WHERE p.isActive = true";
            return em.createQuery(query, Prueba.class).getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Prueba updatePrueba(Prueba prueba){
        try {
            String query = "SELECT p FROM Prueba p WHERE p.nombre = :nombre AND p.isActive = true";
            Prueba pruebaFound = em.createQuery(query, Prueba.class).setParameter("nombre", prueba.getNombre()).getSingleResult();
            if(pruebaFound==null){
                return null;
            }
            pruebaFound.setFecha(prueba.getFecha());
            pruebaFound.setNombre(prueba.getNombre());
            pruebaFound.setObservaciones(prueba.getObservaciones());
            em.merge(pruebaFound);
            return pruebaFound;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deletePruebaById(UUID id){
        try {
            String query = "SELECT p FROM Prueba p WHERE p.prueba_id = :id AND p.isActive = true";
            Prueba prueba = em.createQuery(query, Prueba.class).setParameter("id", id).getSingleResult();
            prueba.setActive(false);
            em.merge(prueba);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

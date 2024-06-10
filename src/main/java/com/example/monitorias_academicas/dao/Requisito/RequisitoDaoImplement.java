package com.example.monitorias_academicas.dao.Requisito;


import com.example.monitorias_academicas.entitys.Requisito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RequisitoDaoImplement implements RequisitoDao{
    @PersistenceContext
    EntityManager em;

    @Override
    public Requisito createRequisito(Requisito requisito){
        try {
            requisito.setEstado(requisito.getEstado().toLowerCase());
            em.merge(requisito);
            return requisito;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Requisito> getAllRequisito(){
        try {
            String query = "SELECT r FROM Requisito r WHERE r.estado = 'activo'";
            List<Requisito> requisitos = em.createQuery(query, Requisito.class).getResultList();
            if(requisitos.isEmpty()){
                return null;
            }
            return requisitos;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

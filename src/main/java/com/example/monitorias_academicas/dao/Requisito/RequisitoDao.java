package com.example.monitorias_academicas.dao.Requisito;

import com.example.monitorias_academicas.entitys.Requisito;

import java.util.List;

public interface RequisitoDao {
    Requisito createRequisito(Requisito requisito);

    List<Requisito> getAllRequisito();
}

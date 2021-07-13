package com.prova.provaesame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.provaesame.Dao.VelocitaDao;

//interfaccia usata come repository per incapsulare i dati e renderli pronti all'utilizzo
public interface VelocitaRepository extends JpaRepository<VelocitaDao, Integer> {
}

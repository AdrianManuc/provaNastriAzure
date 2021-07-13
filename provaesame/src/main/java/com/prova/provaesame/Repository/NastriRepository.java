package com.prova.provaesame.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prova.provaesame.Dao.NastriDao;

//interfaccia usata come repository per incapsulare i dati e renderli pronti all'utilizzo
public interface NastriRepository extends JpaRepository<NastriDao, Integer> {
}

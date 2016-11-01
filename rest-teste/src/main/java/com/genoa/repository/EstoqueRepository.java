package com.genoa.repository;

import com.genoa.model.Estoque;
import com.genoa.model.Faturamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by valdisnei on 24/09/16.
 */

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {

    @Query(value =         "SELECT * FROM bi_user.SETAT_GENOA_ESTOQUE "
        + "                WHERE lote = ?",nativeQuery = true)
    List<Estoque> findByLote(Long lote);


    @Query(value = " SELECT count(1) FROM bi_user.SETAT_GENOA_ESTOQUE "
        + "            WHERE trunc(dtalote) = ? ",nativeQuery = true)
    Long count(LocalDate data);

}

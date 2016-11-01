package com.genoa.repository;

import com.genoa.model.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by valdisnei on 24/09/16.
 */

@Repository
public interface VendasRepository extends JpaRepository<Vendas,Long> {

    @Query(value = "SELECT * FROM bi_user.setat_genoa_vendas\n"
        + "                WHERE lote = ?",nativeQuery = true)
    List<Vendas> findByLote(Long lote);


    @Query(value = " SELECT count(1) FROM bi_user.setat_genoa_vendas "
        + "            WHERE trunc(dtalote) = ? ",nativeQuery = true)
    Long count(LocalDate data);

}

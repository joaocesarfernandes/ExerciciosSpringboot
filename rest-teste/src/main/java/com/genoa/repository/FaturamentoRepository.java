package com.genoa.repository;

import com.genoa.model.Compra;
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
public interface FaturamentoRepository extends JpaRepository<Faturamento,Long> {

    @Query(value =         "SELECT * FROM bi_user.SETAT_GENOA_PROD_PEND_FAT\n"
        + "                WHERE lote = ?",nativeQuery = true)
    List<Faturamento> findByLote(Long lote);


    @Query(value = " SELECT count(1) FROM bi_user.SETAT_GENOA_PROD_PEND_FAT "
        + "            WHERE trunc(dtalote) = ? ",nativeQuery = true)
    Long count(LocalDate data);

}

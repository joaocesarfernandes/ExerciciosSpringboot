package com.genoa.repository;

import com.genoa.model.Catalogo;
import com.genoa.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by valdisnei on 24/09/16.
 */

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo,Long> {

    @Query(value =         "SELECT * FROM bi_user.SETAT_GENOA_CATALOGO "
        + "                WHERE lote = ?",nativeQuery = true)
    List<Catalogo> findByLote(Long lote);


    @Query(value = " SELECT count(1) FROM bi_user.SETAT_GENOA_CATALOGO "
        + "            WHERE trunc(dtalote) = ? ",nativeQuery = true)
    Long count(LocalDate data);

}

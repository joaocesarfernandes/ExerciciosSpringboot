package com.genoa.repository;

import com.genoa.model.Lote;
import com.genoa.model.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by valdisnei on 24/09/16.
 */

@Repository
public interface LoteRepository extends JpaRepository<Lote,Long> {



    @Query(value = "select lote,trunc(DTAHORA_EXTRACAO) dta_extracao,dtalote,count(1) quantidade from bi_user.SETAT_GENOA_VENDAS "
        + "        where lote is not null and trunc(dtalote) = ? "
        + "        group by lote,trunc(DTAHORA_EXTRACAO),dtalote order by lote",nativeQuery = true)
    List<Lote> listLoteVendas(LocalDate dtalote);

    @Query(value = "select lote,trunc(DTA_EXTRACAO) dta_extracao,dtalote,count(1) quantidade from bi_user.SETAT_GENOA_PED_PEND_COMPRA "
        + "        where lote is not null and trunc(dtalote) = ? "
        + "        group by lote,trunc(DTA_EXTRACAO),dtalote order by lote",nativeQuery = true)
    List<Lote> listLoteCompra(LocalDate localDate);

    @Query(value = "select lote,trunc(DTA_EXTRACAO) dta_extracao,dtalote,count(1) quantidade from bi_user.SETAT_GENOA_ESTOQUE "
        + "        where lote is not null and trunc(dtalote) = ? "
        + "        group by lote,trunc(DTA_EXTRACAO),dtalote order by lote",nativeQuery = true)
    List<Lote> listLoteEstoque(LocalDate localDate);

    @Query(value = "select lote,trunc(DTA_EXTRACAO) dta_extracao,dtalote,count(1) quantidade from bi_user.SETAT_GENOA_PROD_PEND_FAT "
        + "        where lote is not null and trunc(dtalote) = ? "
        + "        group by lote,trunc(DTA_EXTRACAO),dtalote order by lote",nativeQuery = true)
    List<Lote> listLoteFaturamento(LocalDate localDate);

    @Query(value = "select lote,trunc(DTA_EXTRACAO) dta_extracao,dtalote,count(1) quantidade from bi_user.SETAT_GENOA_PROD_PEND_REC "
        + "        where lote is not null and trunc(dtalote) = ? "
        + "        group by lote,DTA_EXTRACAO,dtalote order by lote",nativeQuery = true)
    List<Lote> listLoteRecebimento(LocalDate localDate);

    @Query(value = "select lote,trunc(DTA_EXTRACAO) dta_extracao,dtalote,count(1) quantidade from bi_user.SETAT_GENOA_CATALOGO "
        + "        where lote is not null and trunc(dtalote) = ? "
        + "        group by lote,trunc(DTA_EXTRACAO),dtalote order by lote",nativeQuery = true)
    List<Lote> listLoteCatalogo(LocalDate localDate);

    @Query(value = "select lote,trunc(DTA_EXTRACAO) dta_extracao,dtalote,count(1) quantidade from bi_user.SETAT_GENOA_CATALOGO_STATUS "
        + "        where lote is not null and trunc(dtalote) = ? "
        + "        group by lote,trunc(DTA_EXTRACAO),dtalote order by lote",nativeQuery = true)
    List<Lote> listLoteCatalogoStatus(LocalDate localDate);

}

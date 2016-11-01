package com.genoa.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import java.util.List;

/**
 * Created by valdisnei on 31/05/16.
 */
@AutoProperty
public class Result {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long lote;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String dataMovimentacao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String dataLote;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long totalRegistrosGeral;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long totalRegistrosLote;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long totalLote;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List lista;

    public Result(Long lote, String dataParametro, String dataLote, Long totalRegistrosGeral, Long totalLote, Long totalLote1, List lista) {
        this.lote = lote;
        this.dataMovimentacao = dataParametro;
        this.dataLote = dataLote;
        this.totalRegistrosGeral = totalRegistrosGeral;
        this.totalRegistrosLote = totalLote;
        this.totalLote = totalLote1;
        this.lista = lista;
    }

    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    public String getDataLote() {return dataLote;}

    public Long getTotalRegistrosGeral() {
        return totalRegistrosGeral;
    }

    public List getLista() {return lista;}

    public Long getLote() {return lote;}

    public Long getTotalRegistrosLote() {return totalRegistrosLote;}

    public Long getTotalLote() {
        return totalLote;
    }

    @Override
    public String toString() {
        return Pojomatic.toString(this);
    }
}

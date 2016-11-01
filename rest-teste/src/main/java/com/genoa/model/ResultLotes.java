package com.genoa.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import java.util.Map;

/**
 * Created by valdisnei on 31/05/16.
 */
@AutoProperty
public class ResultLotes {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String dataExtracao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String dataLote;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Map<Long,Long> listaLotes;

    public ResultLotes(String dataExtracao, String dataLote, Map<Long, Long> lista) {
        this.dataExtracao = dataExtracao;
        this.dataLote = dataLote;
        this.listaLotes = lista;
    }

    public String getDataExtracao() {
        return dataExtracao;
    }

    public String getDataLote() {
        return dataLote;
    }

    public Map<Long, Long> getListaLotes() {
        return listaLotes;
    }

    @Override
    public String toString() {
        return Pojomatic.toString(this);
    }
}

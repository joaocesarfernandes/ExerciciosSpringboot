package com.genoa.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;

import static com.genoa.model.ModelGenoa.DATE_FORMATTER;
import static com.genoa.model.ModelGenoa.DATE_FORMATTER_DATA_EXTRACAO;

/**
 * Created by valdisnei on 23/09/16.
 */
@AutoProperty
@Entity
public class Lote implements Serializable {

    @Id
    @Column(name = "lote")
    private Long numeroLote;

    @JsonIgnore
    @Column(name = "dta_extracao")
    private LocalDate localDate;

    @Column(name = "QUANTIDADE")
    private Long quantidade;

    @JsonProperty("dataMovimentacao")
    @Transient
    private String localDateString;

    @JsonIgnore
    @Column(name = "dtalote")
    private LocalDate dataLote;


    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getDataLote() {
        return dataLote;
    }

    public void setDataLote(LocalDate dataLote) {
        this.dataLote = dataLote;
    }

    public Long getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(Long numeroLote) {
        this.numeroLote = numeroLote;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getLocalDateString() {
        return this.localDate.format(DATE_FORMATTER);
    }

    public void setLocalDateString(String localDateString) {
        this.localDateString = this.localDate.format(DATE_FORMATTER);
    }

    @Override public String toString() {
        return Pojomatic.toString(this);
    }


}

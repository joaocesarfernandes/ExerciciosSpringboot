package com.genoa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by valdisnei on 26/09/16.
 */
public class ModelGenoa {
    public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy").withLocale(new Locale("pt_BR"));
    public static DateTimeFormatter DATE_FORMATTER_DATA_EXTRACAO = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").withLocale(new Locale("pt_BR"));

    @JsonIgnore
    @Column(name = "dtalote")
    LocalDate dataLote;


    @JsonIgnore
    @Column(name = "dta_extracao")
    private LocalDateTime dtaextracao;

    @JsonProperty("dta_extracao")
    @Transient
    private String formattedDataExtra;



    public LocalDate getDataLote() {
        return dataLote;
    }

    public void setDataLote(LocalDate dataLote) {
        this.dataLote = dataLote;
    }


    public LocalDateTime getDtaextracao() {
        return dtaextracao;
    }

    public void setDtaextracao(LocalDateTime dtaextracao) {
        this.dtaextracao = dtaextracao;
    }


    public String getFormattedDataExtra() {
        return this.dtaextracao.format(DATE_FORMATTER);
    }

    public void setFormattedDataExtra(String formattedDataExtra) {
        this.formattedDataExtra = this.dtaextracao.format(DATE_FORMATTER);
    }



}

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
import java.time.LocalDateTime;

import static com.genoa.model.ModelGenoa.DATE_FORMATTER_DATA_EXTRACAO;

/**
 * Created by valdisnei on 23/09/16.
 */
@AutoProperty
@Entity
public class CatalogoStatus implements Serializable {

    @Id
    @JsonIgnore
    @Column(name = "ID_CAT_STATUS")
    private Long idCatalogoStatus;

    @JsonProperty("SEQPRODUTO")
    @Column(name = "seqproduto")
    private Long seqproduto;

    @JsonProperty("NROEMPRESA")
    @Column(name = "nroempresa")
    private Long nroempresa;

    @JsonProperty("NOMEREDUZIDO")
    @Column(name = "nomereduzido")
    private String nomeReduzido;

    @JsonProperty("DESCCOMPLETA")
    @Column(name = "desccompleta")
    private String desccompleta;

    @JsonProperty("STATUSCOMPRAPRODUTO")
    @Column(name = "statuscompraproduto")
    private String statuscompraproduto;

    @JsonProperty("STATUSVENDAPRODUTO")
    @Column(name = "statusvendaproduto")
    private String statusvendaproduto;

    @JsonIgnore
    @Column(name = "dtalote")
    private LocalDate dataLote;

    @JsonIgnore
    @Column(name = "dta_extracao")
    private LocalDateTime dtaExtracao;

    @JsonProperty("DTA_EXTRACAO")
    @Transient
    private String formattedDataExtra;

    public Long getIdCatalogoStatus() {return idCatalogoStatus;}

    public void setIdCatalogoStatus(Long idCatalogoStatus) {this.idCatalogoStatus = idCatalogoStatus;}

    public String getFormattedDataExtra() {
        return this.dtaExtracao.format(DATE_FORMATTER_DATA_EXTRACAO);
    }

    public void setFormattedDataExtra(String formattedDataExtra) {
        this.formattedDataExtra = this.dtaExtracao.format(DATE_FORMATTER_DATA_EXTRACAO);
    }

    public Long getSeqproduto() {
        return seqproduto;
    }

    public void setSeqproduto(Long seqproduto) {
        this.seqproduto = seqproduto;
    }

    public Long getNroempresa() {
        return nroempresa;
    }

    public void setNroempresa(Long nroempresa) {
        this.nroempresa = nroempresa;
    }

    public String getNomeReduzido() {
        return nomeReduzido;
    }

    public void setNomeReduzido(String nomeReduzido) {
        this.nomeReduzido = nomeReduzido;
    }

    public String getDesccompleta() {
        return desccompleta;
    }

    public void setDesccompleta(String desccompleta) {
        this.desccompleta = desccompleta;
    }

    public String getStatuscompraproduto() {
        return statuscompraproduto;
    }

    public void setStatuscompraproduto(String statuscompraproduto) {
        this.statuscompraproduto = statuscompraproduto;
    }

    public String getStatusvendaproduto() {
        return statusvendaproduto;
    }

    public void setStatusvendaproduto(String statusvendaproduto) {
        this.statusvendaproduto = statusvendaproduto;
    }

    public LocalDate getDataLote() {return dataLote;}

    public void setDataLote(LocalDate dataLote) {this.dataLote = dataLote;}

    public LocalDateTime getDtaExtracao() {
        return dtaExtracao;
    }

    public void setDtaExtracao(LocalDateTime dtaExtracao) {
        this.dtaExtracao = dtaExtracao;
    }

    @Override public String toString() {
        return Pojomatic.toString(this);
    }


}

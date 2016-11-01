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

import static com.genoa.model.ModelGenoa.DATE_FORMATTER;
import static com.genoa.model.ModelGenoa.DATE_FORMATTER_DATA_EXTRACAO;

/**
 * Created by valdisnei on 23/09/16.
 */
@AutoProperty
@Entity
public class Estoque implements Serializable {

    @Id
    @JsonIgnore
    @Column(name = "ID_ESTOQUE")
    private Long idEstoque;

    @JsonProperty("NROEMPRESA")
    @Column(name = "nroempresa")
    private String nroempresa;

    @JsonProperty("SEQPRODUTO")
    @Column(name = "SEQPRODUTO")
    private Long seqproduto;

    @JsonIgnore
    @Column(name = "dta_estoque")
    private LocalDate dtaestoque;

    @JsonProperty("DTA_ESTOQUE")
    @Transient
    private String formattedDtaestoque;

    @JsonProperty("ESTOQUE_DISPONIVEL")
    @Column(name = "estoque_disponivel")
    private Long estoqueDisponivel;

    @JsonProperty("ESTOQUE_TROCA")
    @Column(name = "estoque_troca")
    private Long estoqueTroca;

    @JsonProperty("QTD_RESERVA_VDA")
    @Column(name = "qtd_reserva_vda")
    private Long qtdReservaVda;

    @JsonProperty("CUSTOMEDIOPRODUTO")
    @Column(name = "customedioproduto")
    private Long customedioproduto;

    @JsonIgnore
    @Column(name = "dtalote")
    private LocalDate dataLote;


    @JsonIgnore
    @Column(name = "dta_extracao")
    private LocalDateTime dtaextracao;

    @JsonProperty("DTA_EXTRACAO")
    @Transient
    private String formattedDataExtra;

    public Long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Long getSeqproduto() {
        return seqproduto;
    }

    public void setSeqproduto(Long seqproduto) {
        this.seqproduto = seqproduto;
    }

    public LocalDate getDtaestoque() {
        return dtaestoque;
    }

    public void setDtaestoque(LocalDate dtaestoque) {
        this.dtaestoque = dtaestoque;
    }

    public String getNroempresa() {
        return nroempresa;
    }

    public void setNroempresa(String nroempresa) {
        this.nroempresa = nroempresa;
    }

    public Long getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public void setEstoqueDisponivel(Long estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public Long getEstoqueTroca() {
        return estoqueTroca;
    }

    public void setEstoqueTroca(Long estoqueTroca) {
        this.estoqueTroca = estoqueTroca;
    }

    public Long getQtdReservaVda() {
        return qtdReservaVda;
    }

    public void setQtdReservaVda(Long qtdReservaVda) {
        this.qtdReservaVda = qtdReservaVda;
    }

    public Long getCustomedioproduto() {
        return customedioproduto;
    }

    public void setCustomedioproduto(Long customedioproduto) {
        this.customedioproduto = customedioproduto;
    }

    public LocalDateTime getDtaextracao() {
        return dtaextracao;
    }

    public void setDtaextracao(LocalDateTime dtaextracao) {
        this.dtaextracao = dtaextracao;
    }

    public String getFormattedDataExtra() {
        return this.dtaextracao.format(DATE_FORMATTER_DATA_EXTRACAO);
    }

    public void setFormattedDataExtra(String formattedDataExtra) {
        this.formattedDataExtra = this.dtaextracao.format(DATE_FORMATTER_DATA_EXTRACAO);
    }

    public String getFormattedDtaestoque() {
        return this.dtaestoque.format(DATE_FORMATTER);
    }

    public void setFormattedDtaestoque(String formattedDtaestoque) {
        this.formattedDtaestoque = this.dtaestoque.format(DATE_FORMATTER);
    }

    public LocalDate getDataLote() {
        return dataLote;
    }

    public void setDataLote(LocalDate dataLote) {
        this.dataLote = dataLote;
    }

    @Override public String toString() {
        return Pojomatic.toString(this);
    }


}

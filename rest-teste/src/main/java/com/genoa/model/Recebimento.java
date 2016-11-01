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
public class Recebimento implements Serializable {

    @Id
    @JsonIgnore
    @Column(name = "ID_PEND_REC")
    private Long idRecebimento;

    @JsonProperty("SEQPRODUTO")
    @Column(name = "seqproduto")
    private Long seqproduto;

    @JsonProperty("NRO_EMP_ORIGEM")
    @Column(name = "nro_emp_origem")
    private String nroemporigem;

    @JsonProperty("EMPRESA_ORIGEM")
    @Column(name = "empresa_origem")
    private String empresaorigem;

    @JsonProperty("NRO_EMP_DESTINO")
    @Column(name = "nro_emp_destino")
    private String nroempdestino;

    @JsonProperty("EMPRESA_DESTINO")
    @Column(name = "empresa_destino")
    private String empresadestino;

    @JsonIgnore
    @Column(name = "dtahoremissao")
    private LocalDate dtaemissao;


    @JsonProperty("DTAHOREMISSAO")
    @Transient
    private String formattedDtahoremissao;

    @JsonProperty("NRO_NOTAFISCAL")
    @Column(name = "nro_notafiscal")
    private String nronotafiscal;

    @JsonProperty("SERIE_NOTAFISCAL")
    @Column(name = "serie_notafiscal")
    private String serienotafiscal;

    @JsonProperty("QTD_EMBALAGEM")
    @Column(name = "qtd_embalagem")
    private Long qtdEmbalagem;

    @JsonProperty("QUANTIDADE")
    @Column(name = "quantidade")
    private Long quantidade;

    @JsonIgnore
    @Column(name = "dtalote")
    private LocalDate dataLote;


    @JsonIgnore
    @Column(name = "dta_extracao")
    private LocalDateTime dtaextracao;

    @JsonProperty("DTA_EXTRACAO")
    @Transient
    private String formattedDataExtra;

    @JsonProperty("VALOR_TOTAL")
    @Column(name = "valor_total")
    private Double valorTotal;

    public Long getIdRecebimento() {
        return idRecebimento;
    }

    public void setIdRecebimento(Long idRecebimento) {
        this.idRecebimento = idRecebimento;
    }

    public Long getSeqproduto() {
        return seqproduto;
    }

    public void setSeqproduto(Long seqproduto) {
        this.seqproduto = seqproduto;
    }

    public String getNroemporigem() {
        return nroemporigem;
    }

    public void setNroemporigem(String nroemporigem) {
        this.nroemporigem = nroemporigem;
    }

    public String getEmpresaorigem() {
        return empresaorigem;
    }

    public void setEmpresaorigem(String empresaorigem) {
        this.empresaorigem = empresaorigem;
    }

    public String getNroempdestino() {
        return nroempdestino;
    }

    public void setNroempdestino(String nroempdestino) {
        this.nroempdestino = nroempdestino;
    }

    public String getEmpresadestino() {
        return empresadestino;
    }

    public void setEmpresadestino(String empresadestino) {
        this.empresadestino = empresadestino;
    }

    public LocalDate getDtaemissao() {
        return dtaemissao;
    }

    public void setDtaemissao(LocalDate dtaemissao) {
        this.dtaemissao = dtaemissao;
    }

    public String getNronotafiscal() {
        return nronotafiscal;
    }

    public void setNronotafiscal(String nronotafiscal) {
        this.nronotafiscal = nronotafiscal;
    }

    public String getSerienotafiscal() {
        return serienotafiscal;
    }

    public void setSerienotafiscal(String serienotafiscal) {
        this.serienotafiscal = serienotafiscal;
    }

    public Long getQtdEmbalagem() {
        return qtdEmbalagem;
    }

    public void setQtdEmbalagem(Long qtdEmbalagem) {
        this.qtdEmbalagem = qtdEmbalagem;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDtaextracao() {
        return dtaextracao;
    }

    public void setDtaextracao(LocalDateTime dtaextracao) {
        this.dtaextracao = dtaextracao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormattedDataExtra() {
        return this.dtaextracao.format(DATE_FORMATTER_DATA_EXTRACAO);
    }

    public void setFormattedDataExtra(String formattedDataExtra) {
        this.formattedDataExtra = this.dtaextracao.format(DATE_FORMATTER_DATA_EXTRACAO);
    }

    public String getFormattedDtahoremissao() {
        return this.dtaemissao.format(DATE_FORMATTER);
    }

    public void setFormattedDtahoremissao(String formattedDtahoremissao) {
        this.formattedDtahoremissao = this.dtaemissao.format(DATE_FORMATTER);
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

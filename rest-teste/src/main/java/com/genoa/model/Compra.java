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
public class Compra  implements Serializable {

    @Id
    @JsonIgnore
    @Column(name = "ID_PEND_COMPRA")
    private Long idCompra;

    @JsonProperty("SEQPRODUTO")
    @Column(name = "SEQPRODUTO")
    private Long seqproduto;

    @JsonProperty("ORIGEMPEDIDO")
    @Column(name = "ORIGEMPEDIDO")
    private Long origempedido;

    @JsonProperty("NROPEDIDOSUPRIM")
    @Column(name = "NROPEDIDOSUPRIM")
    private String nropedidosuprim;

    @JsonIgnore
    @Column(name = "DTAEMISSAO")
    private LocalDate dtaemissao;

    @JsonProperty("DTAEMISSAO")
    @Transient
    private String formattedDtaemissao;

    @JsonProperty("SEQFORNECEDOR")
    @Column(name = "SEQFORNECEDOR")
    private Long seqfornecedor;


    @JsonProperty("NOMERAZAO")
    @Column(name = "NOMERAZAO")
    private String nomerazao;


    @JsonProperty("QTD_SOLICITADA")
    @Column(name = "QTD_SOLICITADA")
    private Long qtdSolicitada;

    @JsonProperty("QTD_PENDENTE")
    @Column(name = "QTD_PENDENTE")
    private Long qtdPendente;

    @JsonProperty("QTD_NF")
    @Column(name = "QTD_NF")
    private Long qtdnf;


    @JsonProperty("VALOR_PENDENTE")
    @Column(name = "VALOR_PENDENTE")
    private Double valorPendente;

    @JsonIgnore
    @Column(name = "DTALOTE")
    LocalDate dataLote;

    @JsonIgnore
    @Column(name = "DTA_EXTRACAO")
    private LocalDateTime dtaextracao;

    @JsonProperty("DTA_EXTRACAO")
    @Transient
    private String formattedDataExtra;

    public Long getIdCompra() {return idCompra;}

    public void setIdCompra(Long idCompra) {this.idCompra = idCompra;}

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
        return this.dtaextracao.format(DATE_FORMATTER_DATA_EXTRACAO);
    }

    public void setFormattedDataExtra(String formattedDataExtra) {
        this.formattedDataExtra = this.dtaextracao.format(DATE_FORMATTER_DATA_EXTRACAO);
    }



    public Long getOrigempedido() {
        return origempedido;
    }

    public void setOrigempedido(Long origempedido) {
        this.origempedido = origempedido;
    }

    public String getNropedidosuprim() {
        return nropedidosuprim;
    }

    public void setNropedidosuprim(String nropedidosuprim) {
        this.nropedidosuprim = nropedidosuprim;
    }

    public LocalDate getDtaemissao() {
        return dtaemissao;
    }

    public void setDtaemissao(LocalDate dtaemissao) {
        this.dtaemissao = dtaemissao;
    }

    public Long getSeqfornecedor() {
        return seqfornecedor;
    }

    public void setSeqfornecedor(Long seqfornecedor) {
        this.seqfornecedor = seqfornecedor;
    }

    public String getNomerazao() {
        return nomerazao;
    }

    public void setNomerazao(String nomerazao) {
        this.nomerazao = nomerazao;
    }

    public Long getSeqproduto() {
        return seqproduto;
    }

    public void setSeqproduto(Long seqproduto) {
        this.seqproduto = seqproduto;
    }

    public Long getQtdSolicitada() {
        return qtdSolicitada;
    }

    public void setQtdSolicitada(Long qtdSolicitada) {
        this.qtdSolicitada = qtdSolicitada;
    }

    public Long getQtdPendente() {
        return qtdPendente;
    }

    public void setQtdPendente(Long qtdPendente) {
        this.qtdPendente = qtdPendente;
    }

    public Long getQtdnf() {
        return qtdnf;
    }

    public void setQtdnf(Long qtdnf) {
        this.qtdnf = qtdnf;
    }

    public Double getValorPendente() {
        return valorPendente;
    }

    public void setValorPendente(Double valorPendente) {
        this.valorPendente = valorPendente;
    }


    public String getFormattedDtaemissao() {
        return this.dtaemissao.format(DATE_FORMATTER);
    }

    public void setFormattedDtaemissao(String formattedDtaemissao) {
        this.formattedDtaemissao = this.dtaemissao.format(DATE_FORMATTER);
    }

    @Override public String toString() {
        return Pojomatic.toString(this);
    }


}

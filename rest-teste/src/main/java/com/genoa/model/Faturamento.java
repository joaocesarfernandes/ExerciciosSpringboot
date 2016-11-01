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

/**
 * Created by valdisnei on 23/09/16.
 */
@AutoProperty
@Entity
public class Faturamento extends ModelGenoa implements Serializable {

    @Id
    @JsonIgnore
    @Column(name = "ID_PEND_FAT")
    private Long idFaturamento;


    @JsonProperty("SEQPRODUTO")
    @Column(name = "seqproduto")
    private Long seqproduto;

    @JsonProperty("NRO_EMP_ORIGEM")
    @Column(name = "nro_emp_origem")
    private Long nroemporigem;

    @JsonProperty("EMPRESA_ORIGEM")
    @Column(name = "empresa_origem")
    private String empresaorigem;

    @JsonProperty("NRO_EMP_DESTINO")
    @Column(name = "nro_emp_destino")
    private Long nroempdestino;

    @JsonProperty("EMPRESA_DESTINO")
    @Column(name = "empresa_destino")
    private String empresadestino;

    @JsonIgnore
    @Column(name = "dtapedido")
    private LocalDate dtapedido;

    @JsonProperty("DTAPEDIDO")
    @Transient
    private String formattedDtapedido;

    @JsonProperty("NRO_PEDIDO_VENDA")
    @Column(name = "nro_pedido_venda")
    private String nroPedidoVenda;

    @JsonProperty("QUANTIDADE_UNITARIA")
    @Column(name = "quantidade_unitaria")
    private Long quantidadeUnitaria;

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

    public Long getIdFaturamento() {
        return idFaturamento;
    }

    public void setIdFaturamento(Long idFaturamento) {
        this.idFaturamento = idFaturamento;
    }

    public Long getSeqproduto() {
        return seqproduto;
    }

    public void setSeqproduto(Long seqproduto) {
        this.seqproduto = seqproduto;
    }

    public Long getNroemporigem() {
        return nroemporigem;
    }

    public void setNroemporigem(Long nroemporigem) {
        this.nroemporigem = nroemporigem;
    }

    public String getEmpresaorigem() {
        return empresaorigem;
    }

    public void setEmpresaorigem(String empresaorigem) {
        this.empresaorigem = empresaorigem;
    }

    public Long getNroempdestino() {
        return nroempdestino;
    }

    public void setNroempdestino(Long nroempdestino) {
        this.nroempdestino = nroempdestino;
    }

    public String getEmpresadestino() {
        return empresadestino;
    }

    public void setEmpresadestino(String empresadestino) {
        this.empresadestino = empresadestino;
    }

    public LocalDate getDtapedido() {
        return dtapedido;
    }

    public void setDtapedido(LocalDate dtapedido) {
        this.dtapedido = dtapedido;
    }

    public String getNroPedidoVenda() {
        return nroPedidoVenda;
    }

    public void setNroPedidoVenda(String nroPedidoVenda) {
        this.nroPedidoVenda = nroPedidoVenda;
    }

    public Long getQuantidadeUnitaria() {
        return quantidadeUnitaria;
    }

    public void setQuantidadeUnitaria(Long quantidadeUnitaria) {
        this.quantidadeUnitaria = quantidadeUnitaria;
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

    public String getFormattedDtapedido() {
        return this.dtapedido.format(DATE_FORMATTER);
    }

    public void setFormattedDtapedido(String formattedDtapedido) {
        this.formattedDtapedido = this.dtapedido.format(DATE_FORMATTER);
    }

    @Override public LocalDate getDataLote() {
        return dataLote;
    }

    @Override public void setDataLote(LocalDate dataLote) {
        this.dataLote = dataLote;
    }

    @Override public String toString() {
        return Pojomatic.toString(this);
    }


}

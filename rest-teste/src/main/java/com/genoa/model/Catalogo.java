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
public class Catalogo implements Serializable {

    @Id
    @JsonIgnore
    @Column(name = "ID_CATALOGO")
    private Long idCatalogo;

    @JsonProperty("SEQPRODUTO")
    @Column(name = "seqproduto")
    private Long seqproduto;

    @JsonProperty("DESCCOMPLETA")
    @Column(name = "desccompleta")
    private String desccompleta;

    @JsonProperty("CATEGORIA")
    @Column(name = "categoria")
    private String categoria;

    @JsonProperty("PADRAOEMBCOMPRA")
    @Column(name = "padraoembcompra")
    private Long padraoembcompra;

    @JsonProperty("QTDEMBALAGEM")
    @Column(name = "qtdembalagem")
    private Long qtdembalagem;

    @JsonProperty("PESOBRUTO")
    @Column(name = "pesobruto")
    private Double pesobruto;

    @JsonProperty("PESOLIQUIDO")
    @Column(name = "pesoliquido")
    private Double pesoliquido;

    @JsonProperty("ALTURA")
    @Column(name = "altura")
    private Double altura;

    @JsonProperty("LARGURA")
    @Column(name = "largura")
    private Double largura;

    @JsonProperty("PROFUNDIDADE")
    @Column(name = "profundidade")
    private Double profundidade;

    @JsonIgnore
    @Column(name = "DTAHORINCLUSAO")
    private LocalDate dtahorinclusao;

    @JsonProperty("DTAHORINCLUSAO")
    @Transient
    private String formattedDtahorinclusao;

    @JsonIgnore
    @Column(name = "dtahoralteracao")
    private LocalDate datahoralteracao;

    @JsonProperty("DTAHORALTERACAO")
    @Transient
    private String formattedDatahoralteracao;

    @JsonIgnore
    @Column(name = "dtalote")
    LocalDate dataLote;


    @JsonIgnore
    @Column(name = "dta_extracao")
    private LocalDateTime dtaextracao;

    @JsonProperty("DTA_EXTRACAO")
    @Transient
    private String formattedDataExtra;

    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

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


    public Long getSeqproduto() {
        return seqproduto;
    }

    public void setSeqproduto(Long seqproduto) {
        this.seqproduto = seqproduto;
    }

    public String getDesccompleta() {
        return desccompleta;
    }

    public void setDesccompleta(String desccompleta) {
        this.desccompleta = desccompleta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getPadraoembcompra() {
        return padraoembcompra;
    }

    public void setPadraoembcompra(Long padraoembcompra) {
        this.padraoembcompra = padraoembcompra;
    }

    public Long getQtdembalagem() {
        return qtdembalagem;
    }

    public void setQtdembalagem(Long qtdembalagem) {
        this.qtdembalagem = qtdembalagem;
    }

    public Double getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(Double pesobruto) {
        this.pesobruto = pesobruto;
    }

    public Double getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(Double pesoliquido) {
        this.pesoliquido = pesoliquido;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public LocalDate getDtahorinclusao() {
        return dtahorinclusao;
    }

    public void setDtahorinclusao(LocalDate dtahorinclusao) {
        this.dtahorinclusao = dtahorinclusao;
    }

    public LocalDate getDatahoralteracao() {
        return datahoralteracao;
    }

    public void setDatahoralteracao(LocalDate datahoralteracao) {
        this.datahoralteracao = datahoralteracao;
    }

    public String getFormattedDtahorinclusao() {

        return this.dtahorinclusao!=null?this.dtahorinclusao.format(DATE_FORMATTER):"";
    }

    public void setFormattedDtahorinclusao(String formattedDtahorinclusao) {
        this.formattedDtahorinclusao = this.dtahorinclusao!=null?this.dtahorinclusao.format(DATE_FORMATTER):"";
    }

    public String getFormattedDatahoralteracao() {
        return this.datahoralteracao!=null?this.datahoralteracao.format(DATE_FORMATTER):null;
    }

    public void setFormattedDatahoralteracao(String formattedDatahoralteracao) {
        this.formattedDatahoralteracao = this.datahoralteracao!=null?this.datahoralteracao.format(DATE_FORMATTER):null;
    }

    @Override public String toString() {
        return Pojomatic.toString(this);
    }


}

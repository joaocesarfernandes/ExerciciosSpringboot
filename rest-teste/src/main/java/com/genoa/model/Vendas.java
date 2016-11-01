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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.genoa.model.ModelGenoa.DATE_FORMATTER;
import static com.genoa.model.ModelGenoa.DATE_FORMATTER_DATA_EXTRACAO;

/**
 * Created by valdisnei on 13/06/16.
 */
@AutoProperty
@Entity
public class Vendas implements Serializable{

    @Id
    @JsonIgnore
    @Column(name = "ID_VENDAS")
    private Long idVendas;

    @JsonProperty("SEQPRODUTO")
    @Column(name = "SEQPRODUTO")
    private Long seqproduto;

    @JsonIgnore
    @Column(name = "lote")
    private Long lote;

    @JsonProperty("NROEMPRESA")
    @Column(name = "NROEMPRESA")
    private String nroempresa;

    @JsonProperty("NRODIVISAO")
    @Column(name = "NRODIVISAO")
    private long nrodivisao;

    @JsonProperty("NROSEGMENTO")
    @Column(name = "NROSEGMENTO")
    private long nrosegmento;

    @JsonProperty("QTDVENDPRODDIA")
    @Column(name = "QTDVENDPRODDIA")
    private long qtdvendproddia;

    @JsonProperty("VLRTOTVENDA")
    @Column(name = "VLRTOTVENDA")
    private BigDecimal vlrtotvenda;

    @JsonProperty("INDPROMOCAO")
    @Column(name = "INDPROMOCAO")
    private String indpromocao;

    @JsonIgnore
    @Column(name = "dtaoperacao")
    private LocalDate dataOperacao;

    @JsonProperty("DTAOPERACAO")
    @Transient
    private String dataOperacaoString;

    @JsonIgnore
    @Column(name = "dtalote")
    LocalDate dataLote;


    @JsonIgnore
    @Column(name = "dtahora_extracao")
    private LocalDateTime dtaextracao;

    @JsonProperty("DTA_EXTRACAO")
    @Transient
    private String formattedDataExtra;

    public Long getIdVendas() {return idVendas;}

    public void setIdVendas(Long idVendas) {this.idVendas = idVendas;}

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


    public Long getSeqproduto() {return seqproduto;}

    public void setSeqproduto(Long seqproduto) {this.seqproduto = seqproduto;}

    public Long getLote() {
        return lote;
    }

    public void setLote(Long lote) {
        this.lote = lote;
    }

    public long getNrodivisao() {
        return nrodivisao;
    }

    public void setNrodivisao(long nrodivisao) {
        this.nrodivisao = nrodivisao;
    }

    public long getNrosegmento() {
        return nrosegmento;
    }

    public void setNrosegmento(long nrosegmento) {
        this.nrosegmento = nrosegmento;
    }

    public long getQtdvendproddia() {
        return qtdvendproddia;
    }

    public void setQtdvendproddia(long qtdvendproddia) {
        this.qtdvendproddia = qtdvendproddia;
    }

    public BigDecimal getVlrtotvenda() {
        return vlrtotvenda;
    }

    public void setVlrtotvenda(BigDecimal vlrtotvenda) {
        this.vlrtotvenda = vlrtotvenda;
    }

    public String getIndpromocao() {
        return indpromocao;
    }

    public void setIndpromocao(String indpromocao) {
        this.indpromocao = indpromocao;
    }

    public String getNroempresa() {return nroempresa;}

    public void setNroempresa(String nroempresa) {this.nroempresa = nroempresa;}

    public String getDataOperacaoString() {
        return this.dataOperacao.format(DATE_FORMATTER);
    }

    public void setDataOperacaoString(String dataOperacaoString) {
        this.dataOperacaoString = this.dataOperacao.format(DATE_FORMATTER);
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
    }

    @Override public String toString() {
        return Pojomatic.toString(this);
    }
}

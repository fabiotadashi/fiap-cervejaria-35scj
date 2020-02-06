package br.com.fiap.cervejaria.dto;

import br.com.fiap.cervejaria.entity.Cerveja;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class CervejaDTO {

    private Integer id;
    private String marca;
    private Double teorAlcoolico;
    private Tipo tipo;
    private BigDecimal preco;
    private ZonedDateTime dataLancamento;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAtualizacao;

    public CervejaDTO(){}

    public CervejaDTO(Integer id, String marca, Double teorAlcoolico, Tipo tipo, BigDecimal preco, ZonedDateTime dataLancamento) {
        this.id = id;
        this.marca = marca;
        this.teorAlcoolico = teorAlcoolico;
        this.tipo = tipo;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
    }

    public CervejaDTO(CreateCervejaDTO createCervejaDTO, Integer id) {
        this.id = id;
        this.marca = createCervejaDTO.getMarca();
        this.teorAlcoolico = createCervejaDTO.getTeorAlcoolico();
        this.tipo = createCervejaDTO.getTipo();
        this.preco = createCervejaDTO.getPreco();
        this.dataLancamento = createCervejaDTO.getDataLancamento();
    }

    public CervejaDTO(Cerveja cerveja) {
        this.id = cerveja.getId();
        this.marca = cerveja.getMarca();
        this.teorAlcoolico = cerveja.getTeorAlcoolico();
        this.tipo = cerveja.getTipo();
        this.preco = cerveja.getPreco();
        this.dataLancamento = cerveja.getDataLancamento();
        this.dataCriacao = convertToZonedDateTime(cerveja.getDataCriacao());
        this.dataAtualizacao = convertToZonedDateTime(cerveja.getDataModificacao());
    }

    private ZonedDateTime convertToZonedDateTime(Date dataModificacao) {
        if(dataModificacao != null){
            return ZonedDateTime.ofInstant(dataModificacao.toInstant(), ZoneOffset.systemDefault());
        } else {
            return null;
        }
    }

    public ZonedDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(ZonedDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public ZonedDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(ZonedDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(Double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public ZonedDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(ZonedDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}

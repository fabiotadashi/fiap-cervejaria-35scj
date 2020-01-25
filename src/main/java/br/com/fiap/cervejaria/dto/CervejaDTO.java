package br.com.fiap.cervejaria.dto;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class CervejaDTO {

    private Integer id;
    private String marca;
    private Double teorAlcoolico;
    private Tipo tipo;
    private BigDecimal preco;
    private ZonedDateTime dataLancamento;

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

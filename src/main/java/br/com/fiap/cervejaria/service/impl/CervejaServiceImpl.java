package br.com.fiap.cervejaria.service.impl;

import br.com.fiap.cervejaria.dto.CervejaDTO;
import br.com.fiap.cervejaria.dto.CreateCervejaDTO;
import br.com.fiap.cervejaria.dto.PrecoCervejaDTO;
import br.com.fiap.cervejaria.dto.Tipo;
import br.com.fiap.cervejaria.entity.Cerveja;
import br.com.fiap.cervejaria.repository.CervejaRepository;
import br.com.fiap.cervejaria.service.CervejaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.fiap.cervejaria.dto.Tipo.*;

@Service
public class CervejaServiceImpl implements CervejaService {


    private CervejaRepository cervejaRepository;

    public CervejaServiceImpl(CervejaRepository cervejaRepository){
        this.cervejaRepository = cervejaRepository;
    }

    @Override
    public List<CervejaDTO> findAll(Tipo tipo) {
        return cervejaRepository.findAll()
                .stream()
                .map(CervejaDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CervejaDTO findById(Integer id) {
        return null;
    }

    @Override
    public CervejaDTO create(CreateCervejaDTO createCervejaDTO) {
        Cerveja cerveja = new Cerveja(createCervejaDTO);

        Cerveja savedCerveja = cervejaRepository.save(cerveja);

        return new CervejaDTO(savedCerveja);
    }

    @Override
    public CervejaDTO update(Integer id, CreateCervejaDTO createCervejaDTO) {
        return null;
    }

    @Override
    public CervejaDTO update(Integer id, PrecoCervejaDTO precoCervejaDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}

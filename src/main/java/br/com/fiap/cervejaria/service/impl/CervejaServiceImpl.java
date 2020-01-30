package br.com.fiap.cervejaria.service.impl;

import br.com.fiap.cervejaria.dto.CervejaDTO;
import br.com.fiap.cervejaria.dto.CreateCervejaDTO;
import br.com.fiap.cervejaria.dto.PrecoCervejaDTO;
import br.com.fiap.cervejaria.dto.Tipo;
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

    private List<CervejaDTO> cervejaDTOList;

    public CervejaServiceImpl() {
        cervejaDTOList = new ArrayList<>();

        cervejaDTOList.add(new CervejaDTO(1,
                "Marca 1",
                4.5,
                PILSEN,
                BigDecimal.valueOf(12.9),
                ZonedDateTime.now().minusYears(3)));

        cervejaDTOList.add(new CervejaDTO(2,
                "Marca 2",
                3.5,
                ALE,
                BigDecimal.valueOf(10.9),
                ZonedDateTime.now().minusYears(2)));

        cervejaDTOList.add(new CervejaDTO(3,
                "Marca 1",
                7.5,
                WEISS,
                BigDecimal.valueOf(17.9),
                ZonedDateTime.now().minusYears(1)));

    }

    @Override
    public List<CervejaDTO> findAll(Tipo tipo) {
        return cervejaDTOList.stream()
                .filter(cervejaDTO -> tipo == null || cervejaDTO.getTipo().equals(tipo))
                .collect(Collectors.toList());

    }

    @Override
    public CervejaDTO findById(Integer id) {
        return null;
    }

    @Override
    public CervejaDTO create(CreateCervejaDTO createCervejaDTO) {
        CervejaDTO cervejaDTO = new CervejaDTO(createCervejaDTO, cervejaDTOList.size() + 1);
        cervejaDTOList.add(cervejaDTO);
        return cervejaDTO;
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

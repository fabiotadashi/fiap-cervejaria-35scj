package br.com.fiap.cervejaria.controller;

import br.com.fiap.cervejaria.dto.CervejaDTO;
import br.com.fiap.cervejaria.dto.CreateCervejaDTO;
import br.com.fiap.cervejaria.dto.PrecoCervejaDTO;
import br.com.fiap.cervejaria.dto.Tipo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.fiap.cervejaria.dto.Tipo.*;

@RestController
@RequestMapping("cervejas")
public class CervejaController {

    private List<CervejaDTO> cervejaDTOList;

    public CervejaController() {
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

    @GetMapping
    public List<CervejaDTO> getAll(@RequestParam(required = false) Tipo tipo) {
        return cervejaDTOList.stream()
                .filter(cervejaDTO -> tipo == null || cervejaDTO.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public CervejaDTO findById(@PathVariable Integer id) {
        return cervejaDTOList.stream()
                .filter(cervejaDTO -> cervejaDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CervejaDTO create(@RequestBody @Valid CreateCervejaDTO createCervejaDTO) {
        CervejaDTO cervejaDTO = new CervejaDTO(createCervejaDTO, cervejaDTOList.size() + 1);
        cervejaDTOList.add(cervejaDTO);
        return cervejaDTO;
    }

    @PutMapping("{id}")
    public CervejaDTO update(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO){
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTO.setMarca(createCervejaDTO.getMarca());
        cervejaDTO.setPreco(createCervejaDTO.getPreco());
        cervejaDTO.setTeorAlcoolico(createCervejaDTO.getTeorAlcoolico());
        cervejaDTO.setDataLancamento(createCervejaDTO.getDataLancamento());
        cervejaDTO.setTipo(createCervejaDTO.getTipo());
        return cervejaDTO;
    }

    @PatchMapping("{id}")
    public CervejaDTO update(@PathVariable Integer id, @RequestBody PrecoCervejaDTO precoCervejaDTO){
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTO.setPreco(precoCervejaDTO.getPreco());
        return cervejaDTO;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTOList.remove(cervejaDTO);
    }

}

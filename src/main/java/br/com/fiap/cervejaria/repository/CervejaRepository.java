package br.com.fiap.cervejaria.repository;

import br.com.fiap.cervejaria.dto.Tipo;
import br.com.fiap.cervejaria.entity.Cerveja;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CervejaRepository extends JpaRepository<Cerveja, Integer>{

    Page<Cerveja> findAll(Pageable pageable);

    List<Cerveja> findAllByTipo(Tipo tipo);

    @Query("from Cerveja c where c.tipo = :tipo")
    List<Cerveja> findPorTipo(Tipo tipo);

}

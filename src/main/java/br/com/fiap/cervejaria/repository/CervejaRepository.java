package br.com.fiap.cervejaria.repository;

import br.com.fiap.cervejaria.entity.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CervejaRepository extends JpaRepository<Cerveja, Integer>{

}

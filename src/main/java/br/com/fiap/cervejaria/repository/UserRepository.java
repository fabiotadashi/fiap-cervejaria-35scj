package br.com.fiap.cervejaria.repository;

import br.com.fiap.cervejaria.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

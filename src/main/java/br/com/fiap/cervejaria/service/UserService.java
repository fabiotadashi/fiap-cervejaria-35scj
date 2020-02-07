package br.com.fiap.cervejaria.service;

import br.com.fiap.cervejaria.dto.CreateUserDTO;
import br.com.fiap.cervejaria.dto.UserDTO;

public interface UserService {

    UserDTO create(CreateUserDTO createUserDTO);

}

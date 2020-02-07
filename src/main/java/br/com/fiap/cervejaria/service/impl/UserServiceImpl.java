package br.com.fiap.cervejaria.service.impl;

import br.com.fiap.cervejaria.dto.CreateUserDTO;
import br.com.fiap.cervejaria.dto.UserDTO;
import br.com.fiap.cervejaria.entity.User;
import br.com.fiap.cervejaria.repository.UserRepository;
import br.com.fiap.cervejaria.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setUsername(createUserDTO.getUsername());
        user.setPassword(createUserDTO.getPassword());

        User savedUser = userRepository.save(user);

        return new UserDTO(savedUser);
    }

}

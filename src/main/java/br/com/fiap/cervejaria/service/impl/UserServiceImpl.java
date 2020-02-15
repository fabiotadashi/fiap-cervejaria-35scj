package br.com.fiap.cervejaria.service.impl;

import br.com.fiap.cervejaria.dto.AuthDTO;
import br.com.fiap.cervejaria.dto.CreateUserDTO;
import br.com.fiap.cervejaria.dto.JwtDTO;
import br.com.fiap.cervejaria.dto.UserDTO;
import br.com.fiap.cervejaria.entity.User;
import br.com.fiap.cervejaria.repository.UserRepository;
import br.com.fiap.cervejaria.security.JwtTokenUtil;
import br.com.fiap.cervejaria.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           JwtTokenUtil jwtTokenUtil,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setUsername(createUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));

        User savedUser = userRepository.save(user);

        return new UserDTO(savedUser);
    }

    @Override
    public JwtDTO login(AuthDTO authDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authDTO.getUsername(),
                            authDTO.getPassword()
                    )
            );
        } catch (DisabledException disabledException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user.disabled");
        } catch (BadCredentialsException credentialsExcetpion){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid.credentials");
        }

        String token = jwtTokenUtil.generateToken(authDTO.getUsername());

        JwtDTO jwtDTO = new JwtDTO();
        jwtDTO.setToken(token);
        return jwtDTO;
    }

}

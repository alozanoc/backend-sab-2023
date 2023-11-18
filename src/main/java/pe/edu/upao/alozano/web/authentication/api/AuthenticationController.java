package pe.edu.upao.alozano.web.authentication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upao.alozano.web.authentication.domain.User;
import pe.edu.upao.alozano.web.authentication.mappers.LoginRequest;
import pe.edu.upao.alozano.web.authentication.mappers.LoginResponse;
import pe.edu.upao.alozano.web.authentication.resource.UserRepository;
import pe.edu.upao.alozano.web.util.EncryptionUtil;
import pe.edu.upao.alozano.web.util.JwtTokenUtil;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://sabado-2023.netlify.app"})
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired JwtTokenUtil jwtTokenUtil;


    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping("/login")
    LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
        if (user.isPresent()) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
                return new LoginResponse(EncryptionUtil.encrypt(jwtTokenUtil.generateToken(user.get())));
            } catch (AuthenticationException e) {
                // pass to the throw.
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario y/o password incorrecto");
    }

}

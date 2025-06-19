package ma.enaa.deliverymatchs.Auth;

import ma.enaa.deliverymatchs.Configuration.ServiceJWT;
import ma.enaa.deliverymatchs.Model.*;
import ma.enaa.deliverymatchs.Repo.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AutehnticateServices {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ServiceJWT jwtService;
    private final AuthenticationManager authenticationManager;

    public AutehnticateServices(UserRepository repository, PasswordEncoder passwordEncoder, ServiceJWT jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse register(RegisterRequest request) {
        User user;

        switch (request.getRole()) {
            case ADMIN -> user = new Admin();
            case CONDUCTEUR -> user = new Conducteur();
            case EXPEDITEUR -> user = new Expediteur();

            default -> throw new IllegalArgumentException("Invalid role: " + request.getRole());
        }

        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setEmail(request.getEmail());
        user.setMotDepass(passwordEncoder.encode(request.getMotDePasse()));
        user.setRole(request.getRole());

        repository.save(user);

        String jwtToken = jwtService.generateToken(user);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(jwtToken);
        return response;
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getMotDePasse()
                )
        );

        UserDetails user = repository.findByEmail(request.getEmail());
        String jwtToken = jwtService.generateToken(user);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(jwtToken);
        return response;
    }
}

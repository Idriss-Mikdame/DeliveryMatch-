package ma.enaa.deliverymatchs.Services;

import ma.enaa.deliverymatchs.Dto.UserDto;
import ma.enaa.deliverymatchs.Mapper.UserMapper;
import ma.enaa.deliverymatchs.Model.User;
import ma.enaa.deliverymatchs.Repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices {
    private final UserMapper mapper;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServices(UserMapper mapper, UserRepository repository, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto updateUser(UserDto dto, Long id){
        User user = repository.findById(id).orElse(null);
        if (user == null){
            throw new RuntimeException("user not found");
        }
        user.setNom(dto.getNom());
        user.setPrenom(dto.getPrenom());
        user.setEmail(dto.getEmail());
        user.setMotDepass(passwordEncoder.encode(dto.getMotDepass()));
        return mapper.toDto(user);
    }

    public List<UserDto> getUsersList(){
       return  repository.findAll() .stream()
               .map(mapper::toDto)
               .collect(Collectors.toList());

    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }

}

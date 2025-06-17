package ma.enaa.deliverymatchs.Services;

import ma.enaa.deliverymatchs.Dto.UserDto;
import ma.enaa.deliverymatchs.Mapper.UserMapper;
import ma.enaa.deliverymatchs.Model.User;
import ma.enaa.deliverymatchs.Repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServices(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto AjouterUser(UserDto userDto){
        User user = userMapper.toEntity(userDto);
        User Adduser = userRepository.save(user);
        return userMapper.toDto(Adduser);
    }
    public List<UserDto> AfficherUser(){
        return userRepository.findAll().stream().map(userMapper::toDto)
                .collect(Collectors.toList());
    }
    public UserDto obtenirUserbyid(Long id){
        return userRepository.findById(id).map(userMapper::toDto).orElse(null);
    }

    public UserDto ModifierUser(Long id , UserDto userDto){
        User user = userRepository.findById(id).get();
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        user.setMotDepass(userDto.getMotDepass());
        user.setEstVerifie(userDto.isEstVerifie());
        user.setRole(userDto.getRole());
        userRepository.save(user);
        return userMapper.toDto(user);
    }
    public void SupprimerUser(Long id){
        userRepository.deleteById(id);
    }



}

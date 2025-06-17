package ma.enaa.deliverymatchs.Controller;

import ma.enaa.deliverymatchs.Dto.UserDto;
import ma.enaa.deliverymatchs.Services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<UserDto> AfficherUsers(){
        return   userServices.AfficherUser();
    }
    @PostMapping
    public UserDto AddUser(@RequestBody UserDto userDto){
        return userServices.AjouterUser(userDto);
    }
    @GetMapping("{id}")
    public UserDto ObtinirParid(@PathVariable("id") Long id){
        return userServices.obtenirUserbyid(id);
    }

    @PutMapping("{id}")
    public UserDto ModifierUsere(@PathVariable Long id, @RequestBody UserDto userDto){
        return userServices.ModifierUser(id,userDto);
    }
    @DeleteMapping("{id}")
    public void Supprimer(@PathVariable Long id){
        userServices.SupprimerUser(id);
    }
}

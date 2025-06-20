package ma.enaa.deliverymatchs.Controller;

import ma.enaa.deliverymatchs.Dto.UserDto;
import ma.enaa.deliverymatchs.Services.UserServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServices service;

    public UserController(UserServices service) {
        this.service = service;
    }


    @PutMapping("/update/{id}")
    public UserDto updateUser(@RequestBody UserDto dto, @PathVariable Long id){
        return service.updateUser(dto, id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/userList")
    public List<UserDto> getUsers(){
        return service.getUsersList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}

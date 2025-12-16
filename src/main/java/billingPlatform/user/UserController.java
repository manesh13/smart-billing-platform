package billingPlatform.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> addStudents(@Valid @RequestBody UserEntity userEntity) {
        UserEntity savedUser = userService.saveStudent(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}

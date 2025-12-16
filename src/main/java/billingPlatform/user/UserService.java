package billingPlatform.user;

import billingPlatform.common.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserService {

    private String error = "User not found with id ";
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(int id) {
        Optional<UserEntity> result = userRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else  {
            throw new ResourceNotFoundException(error + id);
        }

    }

    public UserEntity saveUser(@Valid UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}

package billingPlatform.user;

import billingPlatform.common.Exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private String error = "User not found with id ";

    @Autowired
    private UserRepository userRepository;

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

    public UserEntity saveStudent(@Valid UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}

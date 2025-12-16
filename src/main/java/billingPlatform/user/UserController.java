package billingPlatform.user;

import billingPlatform.subscription.application.GetSubscriptionResponse;
import billingPlatform.subscription.application.SubcriptionService;
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
    @Autowired
    SubcriptionService subscriptionService;

//    @PreAuthorize("isAuthenticated()")
//    @Operation(
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
    @GetMapping("/list")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

//    @PreAuthorize("isAuthenticated()")
//    @Operation(
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

//    @PreAuthorize("isAuthenticated()")
//    @Operation(
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
    @PostMapping("/add")
    public ResponseEntity<UserEntity> addStudents(@Valid @RequestBody UserEntity userEntity) {
        UserEntity savedUser = userService.saveUser(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

//    @PreAuthorize("isAuthenticated()")
//    @Operation(
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
    @GetMapping("/subscription/{id}")
    public ResponseEntity<GetSubscriptionResponse> getUserSubscription(@PathVariable int id) {
        return subscriptionService.getSubscriptionByUserId(id);
    }
}

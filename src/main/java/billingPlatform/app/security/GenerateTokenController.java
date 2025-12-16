package billingPlatform.app.security;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")public class GenerateTokenController {

    private final JwtService jwtService;

    public GenerateTokenController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username) {
        return Map.of("token", jwtService.generateToken(username));
    }
}

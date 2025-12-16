package billingPlatform.subscription.controller;

import billingPlatform.subscription.application.SubcriptionService;
import billingPlatform.subscription.domain.SubscriptionEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sub")
public class SubscriptionController {
    @Autowired
    private SubcriptionService subscriptionService;

//    @PreAuthorize("isAuthenticated()")
//    @Operation(
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
    @PostMapping("/add")
    public String addSubscription(@Valid @RequestBody SubscriptionEntity subscriptionEntity) {
        subscriptionService.save(subscriptionEntity);
        return "ADD SUBSCRIPTION";
    }
}

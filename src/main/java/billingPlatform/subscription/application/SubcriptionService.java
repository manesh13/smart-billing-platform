package billingPlatform.subscription.application;

import billingPlatform.subscription.domain.SubscriptionEntity;
import billingPlatform.subscription.domain.SubscriptionMapper;
import billingPlatform.subscription.infrastructure.SubscriptionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubcriptionService {

    private String error = "User not found with id ";

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public ResponseEntity<GetSubscriptionResponse> getSubscriptionByUserId(int id) {
        Optional<SubscriptionEntity> result = subscriptionRepository.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.status(200).body(SubscriptionMapper.toResponse(result.get()));
        } else
            return ResponseEntity.notFound().build();
    }

    public void save(@Valid SubscriptionEntity subscriptionEntity) {
        subscriptionRepository.save(subscriptionEntity);
    }
}

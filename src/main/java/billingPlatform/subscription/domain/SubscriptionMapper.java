package billingPlatform.subscription.domain;

import billingPlatform.subscription.application.GetSubscriptionResponse;
import lombok.Data;

@Data
public class SubscriptionMapper {

    public static GetSubscriptionResponse toResponse(
            SubscriptionEntity subscription
    ) {
        return new GetSubscriptionResponse(
                subscription.getUserId(),
                "userName",
                subscription.getId()
        );
    }
}

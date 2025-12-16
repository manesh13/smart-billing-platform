package billingPlatform.subscription.application;

import lombok.Data;

@Data
public class GetSubscriptionResponse {

    private Long userId;
    private String userName;
    private Long subscriptionId;
    private String plan;

    public GetSubscriptionResponse(
            Long userId,
            String userName,
            Long subscriptionId
    ) {
        this.userId = userId;
        this.userName = userName;
        this.subscriptionId = subscriptionId;
        this.plan = plan;
    }

}

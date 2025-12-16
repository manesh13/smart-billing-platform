package billingPlatform.subscription.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Table(name = "subscriptions")
@Entity
@Data
public class SubscriptionEntity {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column(nullable = false)
    private Long userId;  // from user module (NO FK)

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_id", nullable = false)
    private SubscriptionPlan plan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus status;

    @Column(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    @Column(nullable = false)
    private boolean autoRenew;

}

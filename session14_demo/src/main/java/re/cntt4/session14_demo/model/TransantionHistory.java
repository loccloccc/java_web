package re.cntt4.session14_demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transantion_history")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TransantionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double amount;


    @Column(name = "message")
    private String message;


    @Column(name = "time")
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}

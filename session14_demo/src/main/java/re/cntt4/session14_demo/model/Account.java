package re.cntt4.session14_demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // lam cho id tu tang
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private Double balance;
}

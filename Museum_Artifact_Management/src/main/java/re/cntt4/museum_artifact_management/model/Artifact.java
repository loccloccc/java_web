package re.cntt4.museum_artifact_management.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "artifacts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String origin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}

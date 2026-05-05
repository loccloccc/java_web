package re.cntt4.session15_demo.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private Integer age;


    private String species;
}

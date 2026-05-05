package re.cntt4.employeeanddepartment.model;

import jakarta.persistence.*;
import lombok.*;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}

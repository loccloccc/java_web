package re.cntt4.employeeanddepartment.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "khong duoc de trong")
    private String name;
    @NotNull(message = "Khong duoc de trong")
    @Min(value = 18 , message = "Tuoi khong hop le")
    private Integer age;
    private MultipartFile avatar;
    private Boolean status;
    @NotNull(message = "khong duoc de trong")
    private Long departmentId;
}

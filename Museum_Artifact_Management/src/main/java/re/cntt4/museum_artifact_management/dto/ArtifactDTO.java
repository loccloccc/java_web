package re.cntt4.museum_artifact_management.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArtifactDTO {
    private Long id;
    @NotBlank(message = "Không được để trống")
    @Size(min = 5 , max = 150 , message = "Độ dài chuỗi phải lớn hơn 5 kí tự")
    private String name;
    @NotBlank(message = "Không được bỏ trống")
    private String origin;
    @Past(message = "Không được quá ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}

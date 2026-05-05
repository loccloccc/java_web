package re.cntt4.employeeanddepartment.seeder;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import re.cntt4.employeeanddepartment.model.Department;
import re.cntt4.employeeanddepartment.model.Employee;
import re.cntt4.employeeanddepartment.repository.DepartmentRepository;
import re.cntt4.employeeanddepartment.repository.EmployeeRepositor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepositor employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        if (departmentRepository.count() == 0){
            Department it = new Department(null, "it", "Hanoi", null);
            Department  marketing = new Department(null, "Marketing", "Ho Chi Minh", null);

            departmentRepository.save(it);
            departmentRepository.save(marketing);



            Employee e1 = new Employee(null, "An", 25, "https://cdn-media.sforum.vn/storage/app/media/thanhhuyen/%E1%BA%A3nh%20%C4%91%E1%BA%B9p%20v%C5%A9ng%20t%C3%A0u/1/anh-dep-vung-tau-1.jpg", true, it);
            Employee e2 = new Employee(null, "Bình", 30, "https://cdn-media.sforum.vn/storage/app/media/thanhhuyen/%E1%BA%A3nh%20%C4%91%E1%BA%B9p%20v%C5%A9ng%20t%C3%A0u/1/anh-dep-vung-tau-1.jpg", false, it);
            Employee e3 = new Employee(null, "Cường", 28, "https://cdn-media.sforum.vn/storage/app/media/thanhhuyen/%E1%BA%A3nh%20%C4%91%E1%BA%B9p%20v%C5%A9ng%20t%C3%A0u/1/anh-dep-vung-tau-1.jpg", true, marketing);

            employeeRepository.save(e1);
            employeeRepository.save(e2);
            employeeRepository.save(e3);
        }
    }
}

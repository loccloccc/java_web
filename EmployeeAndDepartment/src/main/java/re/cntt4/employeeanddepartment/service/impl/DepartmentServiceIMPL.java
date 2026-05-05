package re.cntt4.employeeanddepartment.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.cntt4.employeeanddepartment.model.Department;
import re.cntt4.employeeanddepartment.repository.DepartmentRepository;
import re.cntt4.employeeanddepartment.repository.EmployeeRepositor;
import re.cntt4.employeeanddepartment.service.DepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceIMPL implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepositor employeeRepositor;

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Transactional
    public void deleteDepartment(Long id){
        employeeRepositor.clearDepartment(id); // update trước
        departmentRepository.deleteById(id);   // xóa sau
    }
}

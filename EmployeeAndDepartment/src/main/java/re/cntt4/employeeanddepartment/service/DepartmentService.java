package re.cntt4.employeeanddepartment.service;

import re.cntt4.employeeanddepartment.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();
    public Department findById(Long id);
}

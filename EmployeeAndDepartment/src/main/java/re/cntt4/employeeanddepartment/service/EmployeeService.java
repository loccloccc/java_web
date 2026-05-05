package re.cntt4.employeeanddepartment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import re.cntt4.employeeanddepartment.model.Employee;

import java.util.List;


public interface EmployeeService {
    public Page<Employee> getAllEmployee(Pageable pageable);
    void save(Employee employee);
}

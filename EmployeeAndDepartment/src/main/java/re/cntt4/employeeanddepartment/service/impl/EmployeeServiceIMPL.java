package re.cntt4.employeeanddepartment.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import re.cntt4.employeeanddepartment.model.Employee;
import re.cntt4.employeeanddepartment.repository.EmployeeRepositor;
import re.cntt4.employeeanddepartment.service.EmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {

    private final EmployeeRepositor employeeRepositor;

    @Override
    public void save(Employee employee) {
        employeeRepositor.save(employee);
    }

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepositor.findAll(pageable);
    }

    public Page<Employee> searchAdvanced(
            String name,
            Long departmentId,
            Integer minAge,
            Integer maxAge,
            Pageable pageable
    ){

        Specification<Employee> spec = (root, query, cb) -> {

            var predicate = cb.conjunction();

            if (name != null && !name.isEmpty()) {
                predicate.getExpressions().add(
                        cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%")
                );
            }

            if (departmentId != null) {
                predicate.getExpressions().add(
                        cb.equal(root.get("department").get("id"), departmentId)
                );
            }

            if (minAge != null) {
                predicate.getExpressions().add(
                        cb.greaterThanOrEqualTo(root.get("age"), minAge)
                );
            }

            if (maxAge != null) {
                predicate.getExpressions().add(
                        cb.lessThanOrEqualTo(root.get("age"), maxAge)
                );
            }

            return predicate;
        };

        return employeeRepositor.findAll(spec, pageable);
    }
}
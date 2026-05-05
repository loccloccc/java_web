package re.cntt4.employeeanddepartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.cntt4.employeeanddepartment.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department , Long> {
}

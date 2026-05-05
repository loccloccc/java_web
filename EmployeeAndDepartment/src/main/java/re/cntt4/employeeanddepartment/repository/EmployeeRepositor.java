package re.cntt4.employeeanddepartment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import re.cntt4.employeeanddepartment.model.Employee;

@Repository
public interface EmployeeRepositor extends JpaRepository<Employee ,Long>, JpaSpecificationExecutor<Employee> {

    @Modifying
    @Query("UPDATE Employee e SET e.department = null WHERE e.department.id = :deptId")
    void clearDepartment(@Param("deptId") Long deptId);
}
